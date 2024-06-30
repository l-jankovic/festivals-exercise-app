package com.ftn.modul3.zavrsni.jwd.Festivali.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Izvodjac;
import com.ftn.modul3.zavrsni.jwd.Festivali.model.Nastup;

@Repository
public interface NastupRepo extends JpaRepository<Nastup, Long> {
	
//	Nastup findOneById(Long id);
	
	@Query("SELECT n FROM Nastup n WHERE "+
			"(:festivalId IS NULL OR n.festival.id=:festivalId) AND "+
			"(:izvodjacId IS NULL OR n.izvodjac.id=:izvodjacId)")
	Page<Nastup> search(@Param("izvodjacId")Long izvodjacId,@Param("festivalId")Long festivalId,Pageable pageable);
	
	@Query("SELECT i FROM Festival f " +
		       "LEFT JOIN f.nastupi n " +
		       "LEFT JOIN n.izvodjac i " +
		       "WHERE i.drzavaPorekla = :drzavaPorekla " +
		       "AND f.id = :festivalId")
		Izvodjac searchByCountryAndFestivalId(@Param("drzavaPorekla") String drzavaPorekla,
		                                            @Param("festivalId") Long festivalId);
	
}
