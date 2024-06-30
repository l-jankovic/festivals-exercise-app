package com.ftn.modul3.zavrsni.jwd.Festivali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;


@Repository
public interface IzvodjacRepo  extends JpaRepository<Izvodjac,Long>{
	
	Izvodjac findOneById(Long id);
}
