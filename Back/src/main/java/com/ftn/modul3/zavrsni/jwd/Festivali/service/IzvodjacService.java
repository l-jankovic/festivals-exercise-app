package com.ftn.modul3.zavrsni.jwd.Festivali.service;

import java.util.List;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;




public interface IzvodjacService {
	
	
	 Izvodjac findOne(Long id);
	 List<Izvodjac> findAll();
	 Izvodjac save(Izvodjac izvodjac);
}
