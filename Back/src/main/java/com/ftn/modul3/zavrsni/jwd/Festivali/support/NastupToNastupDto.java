package com.ftn.modul3.zavrsni.jwd.Festivali.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.NastupDTO;



@Component
public class NastupToNastupDto implements Converter<Nastup, NastupDTO> {

	@Override
	public NastupDTO convert(Nastup source) {
		NastupDTO dto = new NastupDTO();
		
		dto.setId(source.getId());
		dto.setFestivalId(source.getFestival().getId());
		dto.setNazivFestivala(source.getFestival().getNaziv());
		dto.setIzvodjacId(source.getIzvodjac().getId());
		dto.setImeIzvodjaca(source.getIzvodjac().getIme());
		
		return dto;
	}
	
	 public List<NastupDTO> convert(List<Nastup> nastupi){
	        List<NastupDTO> dto = new ArrayList<>();

	        for(Nastup n: nastupi) {
	            dto.add(convert(n));
	        }

	        return dto;
	    }
	

}
