package com.ftn.modul3.zavrsni.jwd.Festivali.web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.NastupService;
import com.ftn.modul3.zavrsni.jwd.Festivali.support.NastupDtoToNastup;
import com.ftn.modul3.zavrsni.jwd.Festivali.support.NastupToNastupDto;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.NastupDTO;

@RestController
@RequestMapping(value = "/api/nastupi", produces = MediaType.APPLICATION_JSON_VALUE)
public class NastupController {

	@Autowired
	private NastupService nastupService;
	@Autowired
	private NastupDtoToNastup toNastup;
	@Autowired
	private NastupToNastupDto toDto;

	 @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NastupDTO> create(@Valid @RequestBody NastupDTO nastupDto) {
		Nastup n = toNastup.convert(nastupDto);

		if (n.getFestival() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (n.getIzvodjac() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nastup savedN = nastupService.save(n);

		return new ResponseEntity<>(toDto.convert(savedN), HttpStatus.CREATED);
	}

	 @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NastupDTO> update(@PathVariable Long id, @Valid @RequestBody NastupDTO nastupDto) {

		if (!id.equals(nastupDto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nastup n = toNastup.convert(nastupDto);

		if (n.getFestival() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (n.getIzvodjac() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nastup savedN = nastupService.update(n);

		return new ResponseEntity<>(toDto.convert(savedN), HttpStatus.CREATED);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Nastup obrisanNastup = nastupService.delete(id);

		if (obrisanNastup != null) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	  @PermitAll
	  @GetMapping(value = "/page")
	  public ResponseEntity<List<NastupDTO>> getAll(
			  @RequestParam(required = false) Long izvodjacId,
			  @RequestParam(required = false) Long festivalId,
			  @RequestParam(value = "pageNo",defaultValue = "0")int pageNo){
		  
		  Page<Nastup>page;
		 
		  page=nastupService.search(izvodjacId, festivalId, pageNo);
	
		  HttpHeaders headers = new HttpHeaders();
	      headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	      
	      return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
	  }
	  
	  @PermitAll
	  @GetMapping
	  public ResponseEntity<List<NastupDTO>> getAll(
			){
		  
		  List<Nastup>nastupi=nastupService.findAll();
		 
		
	      
	      return new ResponseEntity<>(toDto.convert(nastupi), HttpStatus.OK);
	  }
	  

}
