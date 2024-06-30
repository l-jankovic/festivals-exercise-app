package com.ftn.modul3.zavrsni.jwd.Festivali.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.FestivalService;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.IzvodjacService;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.NastupService;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.IzvodjacDTO;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.NastupDTO;


@Component
public class IzvodjacDtoToIzvodjac implements Converter< IzvodjacDTO, Izvodjac> {

	
	@Autowired
	private IzvodjacService izvodjacService;
	
	@Override
	public Izvodjac convert(IzvodjacDTO source) {
		
		Izvodjac i;
		
		if(source.getId()==null) {
			i=new Izvodjac();
		}else {
			i=izvodjacService.findOne(source.getId());
		}
		
		
		if(i !=null) {
			
			i.setIme(source.getIme());
			i.setZanr(source.getZanr());
			i.setDrzavaPorekla(source.getDrzavaPorekla());
			i.setBrClanova(source.getBrojClanova());
		}
		
		return i;
	}
	

}
