package com.sahar.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sahar.entities.Categorie;
import com.sahar.entities.Instrument;



public interface InstrumentService {
	
	Instrument saveInstrument(Instrument l);
	Instrument updateInstrument(Instrument l);
	void deleteInstrument(Instrument l);
	void deleteInstrumentById(Long id);
	Instrument getInstrument(Long id);
	List<Instrument> getAllInstruments();


	Page<Instrument> getAllInstrumentsParPage(int page, int size);
	
	List<Instrument> findByNomInstrument(String nom);
	List<Instrument> findByNomInstrumentContains(String nom);
	
	List<Instrument> findByCategorie (Categorie categorie);
	List<Instrument> findByCategorieIdCat(Long id);
	
	

	List<Instrument> findByTNomInstrumentPrix (String titre, Double prix);

	List<Instrument> findByOrderByNomInstrumenAsc();
	List<Instrument> trierInstrumentsNomsPrix();
	
}