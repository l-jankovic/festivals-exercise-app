package com.ftn.modul3.zavrsni.jwd.Festivali.service;

import java.util.List;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Festival;




public interface FestivalService {
	
     Festival findOne(Long id);
	 List<Festival> findAll();

}
