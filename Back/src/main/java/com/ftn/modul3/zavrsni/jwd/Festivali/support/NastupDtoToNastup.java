package com.ftn.modul3.zavrsni.jwd.Festivali.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.FestivalService;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.IzvodjacService;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.NastupService;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.NastupDTO;


@Component
public class NastupDtoToNastup  implements Converter< NastupDTO, Nastup>{

	
	@Autowired
	private IzvodjacService izvodjacService;
	
	@Autowired
	private NastupService nastupService;
	@Autowired
	private FestivalService festivalService;
	@Override
	public Nastup convert(NastupDTO source) {
		Nastup n;
		
		if(source.getId()==null) {
			n=new Nastup();
		}else {
			n= nastupService.findOne(source.getId());
		}
		
		if(n!=null) {
			n.setIzvodjac(izvodjacService.findOne(source.getIzvodjacId()));
			n.setFestival(festivalService.findOne(source.getFestivalId()));
		}
		return n;
	}

}
