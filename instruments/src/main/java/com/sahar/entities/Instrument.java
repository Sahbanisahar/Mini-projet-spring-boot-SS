package com.sahar.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;

//import org.springframework.format.annotation.DateTimeFormat;

/////////////////////////////////////////////////////
/*Lombok*/
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
 @NoArgsConstructor
 @AllArgsConstructor
////////////////////////////////////////////////////

@Entity
public class Instrument {
	//cle primere
	@Id
	//auto incrementation
	@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long idInstrument;

	@NotNull
	@Size (min = 4,max = 15)
    private String nomInstrument;

	
	@Max(value = 9999)
	@Min(value = 1)
    private Double prixInstrument;
	
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateFabrication;
    
    ////////////////////////////////////////////////////////////////////////
    @ManyToOne
    private Categorie categorie;
    //Getter & setter de instrument
    public Categorie getCategorie() {
		return categorie;
    }
	public void setGenre(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Instrument [idInstrument=" + idInstrument + ", nomInstrument=" + nomInstrument + ", prixInstrument="
				+ prixInstrument + ", dateFabrication=" + dateFabrication + ", categorie=" + categorie + "]";
	}
	
	
	
	public long getIdInstrument() {
		return idInstrument;
	}
	public void setIdInstrument(long idInstrument) {
		this.idInstrument = idInstrument;
	}
	public String getNomInstrument() {
		return nomInstrument;
	}
	public void setNomInstrument(String nomInstrument) {
		this.nomInstrument = nomInstrument;
	}
	public Double getPrixInstrument() {
		return prixInstrument;
	}
	public void setPrixInstrument(Double prixInstrument) {
		this.prixInstrument = prixInstrument;
	}
	public Date getDateFabrication() {
		return dateFabrication;
	}
	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
    ////////////////////////////////////////////////////////////////////



	





}

