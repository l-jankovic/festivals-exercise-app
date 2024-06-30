package com.ftn.modul3.zavrsni.jwd.Festivali.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Festival;
import com.ftn.modul3.zavrsni.jwd.Festivali.repository.FestivalRepo;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.FestivalService;

@Service
public class JPAFestivalService implements FestivalService {

	@Autowired
	private FestivalRepo repo;
	@Override
	public List<Festival> findAll() {
		return repo.findAll();
	}
	@Override
	public Festival findOne(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseGet(null);
	}
	
	

}
