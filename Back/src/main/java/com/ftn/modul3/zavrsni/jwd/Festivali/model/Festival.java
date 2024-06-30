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
@Entity
public class Festival {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true)
	private String naziv;

	@OneToMany(mappedBy = "festival",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Nastup> nastupi= new ArrayList<Nastup>();	
	
	public Festival() {
		super();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
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
		Festival other = (Festival) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
