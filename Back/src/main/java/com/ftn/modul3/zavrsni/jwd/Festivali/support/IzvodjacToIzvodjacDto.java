package com.ftn.modul3.zavrsni.jwd.Festivali.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.IzvodjacDTO;

@Component
public class IzvodjacToIzvodjacDto implements Converter<  Izvodjac,IzvodjacDTO> {

	@Override
	public IzvodjacDTO convert(Izvodjac source) {
		IzvodjacDTO dto = new IzvodjacDTO();
		
		
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setZanr(source.getZanr());
		dto.setDrzavaPorekla(source.getDrzavaPorekla());
		dto.setBrojClanova(source.getBrClanova());
		
		
		return dto;
	}
	
	
	 public List<IzvodjacDTO> convert(List<Izvodjac> izvodjaci){
	        List<IzvodjacDTO> dto = new ArrayList<>();

	        for(Izvodjac i:izvodjaci ) {
	            dto.add(convert(i));
	        }

	        return dto;
	    }

}
