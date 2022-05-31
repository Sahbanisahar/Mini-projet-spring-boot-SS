package com.sahar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sahar.entities.Categorie;
import com.sahar.entities.Instrument;
import com.sahar.service.CategorieService;
import com.sahar.service.InstrumentService;


@Controller
public class InstrumentController {
	
	@Autowired
	InstrumentService instrumentService;

	@Autowired
	CategorieService categorieService;

	
	@RequestMapping("/ListeInstruments")
	public String listeInstruments(ModelMap modelMap,
								@RequestParam(name = "page", defaultValue = "0") int page,
								@RequestParam(name = "size", defaultValue = "6") int size)
	{
		Page<Instrument> insts = instrumentService.getAllInstrumentsParPage(page, size);
		modelMap.addAttribute("instruments", insts);
		
		//
		List<Categorie> cats = categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		//

		modelMap.addAttribute("pages", new int[insts.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "listeInstruments";
	}
	
	
	
/////////////////////////////////////////////////////////////////////////
	@RequestMapping("/rechercherInstrument")
	public String rechercherProduit(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size, @RequestParam("nomProd") String nomProd,
			@PageableDefault(page = 0, size = 6) Pageable pageable)

	{

		List<Instrument> pros = instrumentService.findByNomInstrumentContains(nomProd);

		int start = (int) pageable.getOffset();
		int end = (int) ((start + pageable.getPageSize()) > pros.size() ? pros.size()
				: (start + pageable.getPageSize()));
		Page<Instrument> prods = new PageImpl<Instrument>(pros.subList(start, end), pageable, pros.size());


		modelMap.addAttribute("produits", prods.getContent());

		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("nomProd", nomProd);
		modelMap.addAttribute("mode", "nom");
		return "recherche";
	}
/////////////////////////////////////////////////////////////////////////
	@RequestMapping("/rechercherInstrumentByCatId")
	public String rechercherProduitByCatId(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "6") int size,
			@RequestParam("id") Long id ,
			@PageableDefault(page = 0, size = 6) Pageable pageable)

	{
		
		List<Categorie> cats = categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		
		List<Instrument> pros = instrumentService.findByCategorieIdCat(id);
		int start = (int) pageable.getOffset();
		int end = (int) ((start + pageable.getPageSize()) > pros.size() ? pros.size()
						: (start + pageable.getPageSize()));
		Page<Instrument> prods = new PageImpl<Instrument>(pros.subList(start, end), pageable, pros.size());
		modelMap.addAttribute("produits", prods.getContent());
		

		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("id", id);
		modelMap.addAttribute("mode", "id");
		return "recherche";
	}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	
	
	@RequestMapping("/supprimerInstrument")
	public String supprimerInstrument(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)

	{
		instrumentService.deleteInstrumentById(id);
	Page<Instrument> insts = instrumentService.getAllInstrumentsParPage(page, size);

	modelMap.addAttribute("instruments", insts);
	modelMap.addAttribute("pages", new int[insts.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeInstruments";
	}
	
	
	
	@RequestMapping("/modifierInstrument")
	public String editerLivre(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Categorie g = categorieService.getCategorie(instrumentService.getInstrument(id).getCategorie().getIdCat());
		modelMap.addAttribute("categorie", g);
		
		Instrument l = instrumentService.getInstrument(id);
		modelMap.addAttribute("instrument", l);
		
		List<Categorie> cats= categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		

		
		modelMap.addAttribute("mode", "edit");
		return "formInstrument";
	}
	
	
	
	/*
	
	@RequestMapping("/creerCategorie")
	public String showCreate(ModelMap modelMap) {
		
		List<Categorie> cats= categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		
		//
		Instrument p = new Instrument();
		Categorie cat = new Categorie(0L,"Selectionnez","",null) ;
		p.setGenre(cat);
		modelMap.addAttribute("instrument", p);
		//
		
		//cats.add(0, cat);
		modelMap.addAttribute("mode", "new");
		return "formBook";
	}
	
	
	*/
	@RequestMapping("/creerInstrument")
	public String showCreate(ModelMap modelMap) {
		
		List<Categorie> cats= categorieService.getAllCategories();
		modelMap.addAttribute("categories", cats);
		
		//
		Instrument p = new Instrument();
		Categorie cat = new Categorie(0L,"Selectionnez","",null) ;
		p.setGenre(cat);
		modelMap.addAttribute("instrument", p);
		//
		
		//cats.add(0, cat);
		modelMap.addAttribute("mode", "new");
		return "formInstrument";
	}
	
	
	
	@RequestMapping("/saveInstrument")
	public String saveProduit(@Valid Instrument instrument, BindingResult bindingResult
								)

	{

		if (bindingResult.hasErrors())
			return "formInstrument";
		
		
		instrumentService.saveInstrument(instrument);

		
		
		return "redirect:/ListeInstruments";
		}
	
	
	

}
