package com.sahar.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahar.entities.Instrument;
import com.sahar.service.InstrumentService;



@RestController
@RequestMapping("/api")
@CrossOrigin

public class InstrumentRESTcontroller {
	
	@Autowired
	InstrumentService instrumentService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Instrument> getAllInstruments()
	{
		return instrumentService.getAllInstruments();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Instrument getInstrumentById(@PathVariable("id") Long id) {
	return instrumentService.getInstrument(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Instrument createInstrument(@RequestBody Instrument instrument) {
	return instrumentService.saveInstrument(instrument);
	}
	
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Instrument updateInstrument(@RequestBody Instrument instrument) {
	return instrumentService.updateInstrument(instrument);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteInstrument(@PathVariable("id") Long id)
	{
		instrumentService.deleteInstrumentById(id);
	}
	
	@RequestMapping(value="/instsgen/{idCat}",method = RequestMethod.GET)
	public List<Instrument> getInstrumentsByCatId(@PathVariable("idCat") Long idCat) {
	return instrumentService.findByCategorieIdCat(idCat);
	}
	

	
	@RequestMapping(value="/nomInst/{nomInstrument}",method = RequestMethod.GET)
	public List<Instrument> findByTitreLivreContains(@PathVariable("nomInstrument") String nomInstrument) {
	return instrumentService.findByNomInstrumentContains(nomInstrument);
	}

}
