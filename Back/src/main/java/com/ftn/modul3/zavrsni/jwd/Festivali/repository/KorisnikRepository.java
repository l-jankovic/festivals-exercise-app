package com.ftn.modul3.zavrsni.jwd.Festivali.repository;




import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Korisnik;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Optional<Korisnik> findFirstByKorisnickoIme(String korisnickoIme);

    Optional<Korisnik> findFirstByKorisnickoImeAndLozinka(String korisnickoIme,String lozinka);
    
  
}
