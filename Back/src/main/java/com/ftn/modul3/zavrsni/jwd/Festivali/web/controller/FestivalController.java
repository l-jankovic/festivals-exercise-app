package com.ftn.modul3.zavrsni.jwd.Festivali.web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Festival;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.FestivalService;
import com.ftn.modul3.zavrsni.jwd.Festivali.support.FestivalToFestivalDto;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.FestivalDTO;

@RestController
@RequestMapping(value = "/api/festivali",produces = MediaType.APPLICATION_JSON_VALUE)
public class FestivalController {
	
	
	@Autowired
	private FestivalService festivalService;
	
	@Autowired
	private FestivalToFestivalDto toDto;
	
	@PermitAll
	@GetMapping
	public ResponseEntity<List<FestivalDTO>> getAll(){
		
		List<Festival> festivali= festivalService.findAll();
		
		
	        
	        
	       return new ResponseEntity<>(toDto.convert(festivali),HttpStatus.OK);

	}
	
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
	
	
	

}
