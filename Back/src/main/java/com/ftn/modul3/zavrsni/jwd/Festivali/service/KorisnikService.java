package com.ftn.modul3.zavrsni.jwd.Festivali.service;



import org.springframework.data.domain.Page;

import com.ftn.modul3.zavrsni.jwd.Festivali.model.Korisnik;
import com.ftn.modul3.zavrsni.jwd.Festivali.web.dto.KorisnikPromenaLozinkeDto;

import java.util.List;
import java.util.Optional;

public interface KorisnikService {

    Optional<Korisnik> findOne(Long id);

    List<Korisnik> findAll();

    Page<Korisnik> findAll(int brojStranice);
    
    Korisnik save(Korisnik korisnik);

    Korisnik delete(Long id);

    Optional<Korisnik> findbyKorisnickoIme(String korisnickoIme);

    boolean changePassword(Long id, KorisnikPromenaLozinkeDto korisnikPromenaLozinkeDto);
}
