package com.ftn.modul3.zavrsni.jwd.Festivali.service.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;
import com.ftn.modul3.zavrsni.jwd.Festivali.repository.NastupRepo;
import com.ftn.modul3.zavrsni.jwd.Festivali.service.NastupService;

@Service
public class JPANastupService implements NastupService {

	@Autowired
	private NastupRepo repo;
	
	@Override
	public Nastup findOne(Long id) {
		return repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	public List<Nastup> findAll() {
			return repo.findAll();
	}

	@Override
	public Page<Nastup> findAll(int pageNo) {
		return repo.findAll(PageRequest.of(pageNo, 2));
	}

	@Override
	public Page<Nastup> search(Long izvodjacId, Long festivalId, int page) {
		return repo.search(izvodjacId, festivalId, PageRequest.of(page, 2));
	}

	@Override
	public Nastup save(Nastup nastup) {
		
		Izvodjac i= repo.searchByCountryAndFestivalId(nastup.getIzvodjac().getDrzavaPorekla(), nastup.getFestival().getId());
		
		if(i==null) {
		return repo.save(nastup);
		}else {
			throw new IllegalArgumentException("Festival cannot have two performers from the same country");
		}
	}

	@Override
	public Nastup update(Nastup nastup) {
		return repo.save(nastup);
	}

	@Override
	public Nastup delete(Long id) {
		Nastup n = findOne(id);
		
		if(n!=null) {
			n.getFestival().getNastupi().remove(n);
			n.getIzvodjac().getNastupi().remove(n);
			repo.delete(n);
			
			return n;
		}
		return null;
	}

}
