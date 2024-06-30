package com.ftn.modul3.zavrsni.jwd.Festivali.web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Festival;
import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.IzvodjacService;
import com.ftn.modul3.zavrsni.jwd.Festivali.support.IzvodjacDtoToIzvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.support.IzvodjacToIzvodjacDto;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.FestivalDTO;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.IzvodjacDTO;

@RestController
@RequestMapping(value = "/api/izvodjaci",produces = MediaType.APPLICATION_JSON_VALUE)
public class IzvodjacController {
	
	
	@Autowired
	private IzvodjacService izvodjacService;
	
	@Autowired
	private IzvodjacToIzvodjacDto toDto;
	
	@Autowired
	private IzvodjacDtoToIzvodjac toIzvodjac;
	
	 @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IzvodjacDTO> create(@Valid @RequestBody IzvodjacDTO izvodjacDTO){
		System.out.println(izvodjacDTO);
		Izvodjac i = toIzvodjac.convert(izvodjacDTO);
		Izvodjac iSacuvan = izvodjacService.save(i);
		
		return new ResponseEntity<IzvodjacDTO>(toDto.convert(iSacuvan),HttpStatus.CREATED);
		
		
	}
	
	@PermitAll
	@GetMapping
	public ResponseEntity<List<IzvodjacDTO>> getAll(){
		
		List<Izvodjac> izvodjaci= izvodjacService.findAll();
		
		
	        
	   return new ResponseEntity<>(toDto.convert(izvodjaci),HttpStatus.OK);

	}
	
}
