package com.ftn.modul3.zavrsni.jwd.Festivali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Festival;



@Repository
public interface FestivalRepo extends JpaRepository<Festival,Long> {
	
	Festival findOneById(Long id);
}
