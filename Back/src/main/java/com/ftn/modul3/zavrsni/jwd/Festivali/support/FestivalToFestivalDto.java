package com.ftn.modul3.zavrsni.jwd.Festivali.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Festival;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.FestivalDTO;

@Component
public class FestivalToFestivalDto implements Converter<Festival, FestivalDTO> {

	@Override
	public FestivalDTO convert(Festival source) {
		FestivalDTO dto= new FestivalDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		
		return dto;
	}
	
	
	 public List<FestivalDTO> convert(List<Festival> festivali){
	        List<FestivalDTO> dto = new ArrayList<>();

	        for(Festival f: festivali) {
	            dto.add(convert(f));
	        }

	        return dto;
	    }
	
	

}
