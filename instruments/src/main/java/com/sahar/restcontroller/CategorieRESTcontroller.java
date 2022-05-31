package com.sahar.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahar.entities.Categorie;
import com.sahar.service.CategorieService;

@RestController
@RequestMapping("/apic")

@CrossOrigin
public class CategorieRESTcontroller {
	
	
	@Autowired
	// Un objet qui implemente cette interface
	CategorieService categorieService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Categorie> getAllCategories() {
		return categorieService.getAllCategories();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id) {
		return categorieService.getCategorie(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Categorie createCategorie(@RequestBody Categorie categorie) {
		return categorieService.saveCategorie(categorie);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Categorie updateCategorie(@RequestBody Categorie categorie) {
		return categorieService.updateCategorie(categorie);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCategorieById(@PathVariable("id") Long id) {
		categorieService.deleteCategorieById(id);
	}

}
