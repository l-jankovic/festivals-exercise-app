package com.ftn.modul3.zavrsni.jwd.Festivali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.repository.IzvodjacRepo;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.IzvodjacService;

@Service
public class JPAIzvodjacService implements IzvodjacService {
	
	@Autowired
	private IzvodjacRepo repo;
	
	@Override
	public List<Izvodjac> findAll() {
		
		return repo.findAll();
	}

	@Override
	public Izvodjac save(Izvodjac izvodjac) {

		return repo.save(izvodjac);
	}

	@Override
	public Izvodjac findOne(Long id) {
		return repo.findOneById(id);
	}

}
