package com.ftn.modul3.zavrsni.jwd.Festivali.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Check;
@Entity
public class Izvodjac {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String ime;
	
	@Column(nullable = false)
	private String zanr;
	@Column(nullable = false)
	private String drzavaPorekla;
	
	@Column(nullable = false)
	@Check(constraints = "brClanova > 0")
	private int brClanova;

	@OneToMany(mappedBy = "izvodjac",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Nastup> nastupi= new ArrayList<Nastup>();	
	
	public Izvodjac() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getDrzavaPorekla() {
		return drzavaPorekla;
	}

	public void setDrzavaPorekla(String drzavaPorekla) {
		this.drzavaPorekla = drzavaPorekla;
	}

	public int getBrClanova() {
		return brClanova;
	}

	public void setBrClanova(int brClanova) {
		this.brClanova = brClanova;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	public List<Nastup> getNastupi() {
		return nastupi;
	}

	public void setNastupi(List<Nastup> nastupi) {
		this.nastupi = nastupi;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Izvodjac other = (Izvodjac) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
