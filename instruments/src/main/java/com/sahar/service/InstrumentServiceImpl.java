package com.sahar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sahar.entities.Categorie;
import com.sahar.entities.Instrument;
import com.sahar.entities.repos.InstrumentRepository;

@Service
public class InstrumentServiceImpl implements InstrumentService{
	
	@Autowired
	InstrumentRepository instrumentRepository;

	@Override
	public Instrument saveInstrument(Instrument l) {
		// TODO Auto-generated method stub
		return instrumentRepository.save(l);
	}

	@Override
	public Instrument updateInstrument(Instrument l) {
		// TODO Auto-generated method stub
		return instrumentRepository.save(l);
	}

	@Override
	public void deleteInstrument(Instrument l) {
		// TODO Auto-generated method stub
		instrumentRepository.delete(l);
		
	}

	@Override
	public void deleteInstrumentById(Long id) {
		// TODO Auto-generated method stub
		instrumentRepository.deleteById(id);
	}

	@Override
	public Instrument getInstrument(Long id) {
		// TODO Auto-generated method stub
		return instrumentRepository.findById(id).get();
	}

	@Override
	public List<Instrument> getAllInstruments() {
		// TODO Auto-generated method stub
		return instrumentRepository.findAll();
	}

	@Override
	public Page<Instrument> getAllInstrumentsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return instrumentRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Instrument> findByNomInstrument(String nom) {
		// TODO Auto-generated method stub
		return instrumentRepository.findByNomInstrument(nom);
	}

	@Override
	public List<Instrument> findByNomInstrumentContains(String nom) {
		// TODO Auto-generated method stub
		return instrumentRepository.findByNomInstrumentContains(nom);
	}

	@Override
	public List<Instrument> findByCategorie(Categorie categorie) {
		return instrumentRepository.findByCategorie(categorie);
	}

	@Override
	public List<Instrument> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return instrumentRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Instrument> findByTNomInstrumentPrix(String titre, Double prix) {
		// TODO Auto-generated method stub
		return instrumentRepository.findByNomPrix(titre, prix);
	}

	@Override
	public List<Instrument> findByOrderByNomInstrumenAsc() {
		return instrumentRepository.findByOrderByNomInstrumentAsc();
	}

	@Override
	public List<Instrument> trierInstrumentsNomsPrix() {
		// TODO Auto-generated method stub
		return instrumentRepository.trierInstrumentsNomsPrix();
	}

}
