package com.ftn.modul3.zavrsni.jwd.Festivali.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;


public interface NastupService {
	

    Nastup findOne(Long id);

    List<Nastup> findAll();
    
    Page<Nastup> findAll(int pageNo);

    Page<Nastup> search(Long izvodjacId,Long festivalId, int page);

    Nastup save(Nastup Nastup);

    Nastup update(Nastup Nastup);

    Nastup delete(Long id);
	


}
