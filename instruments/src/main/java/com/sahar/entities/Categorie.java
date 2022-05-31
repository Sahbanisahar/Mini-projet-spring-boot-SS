package com.sahar.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
	//cle primere
	@Id
	//auto incrementation
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCat;
	
	@NotNull
	@Size (min = 2,max = 30)
	private String nomCat;
	
	@NotNull
	@Size (min = 2, max = 100)
	private String descriptionCat;
	//
	@JsonIgnore
	@OneToMany (mappedBy = "categorie")
	private List<Instrument> instruments;



	public Categorie(Long idCat, @NotNull @Size(min = 2, max = 30) String nomCat,
			@NotNull @Size(min = 2, max = 100) String descriptionCat, List<Instrument> instruments) {
		super();
		this.idCat = idCat;
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
		this.instruments = instruments;
	}



	public Categorie() {
		super();
	}



	@Override
	public String toString() {
		return "Categorie [idCat=" + idCat + ", nomCat=" + nomCat + ", descriptionCat=" + descriptionCat + "]";
	}

	public Long getIdCat() {
		return idCat;
	}

	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public String getDescriptionCat() {
		return descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}
	
	
	
	
	////
	
	
	
}