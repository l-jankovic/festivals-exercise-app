package com.ftn.modul3.zavrsni.jwd.Festivali.web.dto;

public class NastupDTO {
	
	
	private Long id;
	
	
	private Long izvodjacId;
	private String imeIzvodjaca;
	
	private Long festivalId;
	
	private String nazivFestivala;
	
	
	

	public NastupDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIzvodjacId() {
		return izvodjacId;
	}

	public void setIzvodjacId(Long izvodjacId) {
		this.izvodjacId = izvodjacId;
	}

	public String getImeIzvodjaca() {
		return imeIzvodjaca;
	}

	public void setImeIzvodjaca(String imeIzvodjaca) {
		this.imeIzvodjaca = imeIzvodjaca;
	}

	public Long getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(Long festivalId) {
		this.festivalId = festivalId;
	}

	public String getNazivFestivala() {
		return nazivFestivala;
	}

	public void setNazivFestivala(String nazivFestivala) {
		this.nazivFestivala = nazivFestivala;
	}
	
	
	

}
