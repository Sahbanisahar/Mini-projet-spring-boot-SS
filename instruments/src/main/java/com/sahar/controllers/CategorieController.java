package com.sahar.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sahar.entities.Categorie;
import com.sahar.service.CategorieService;

@Controller
public class CategorieController {
	
	@Autowired
	CategorieService categorieService;
	
	@RequestMapping("/ListeCategories")
	public String listeCategories(
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size)
	{
		Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);
		modelMap.addAttribute("categories", cats);

		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "listeCategories";
	}
	
	
	
	@RequestMapping("/supprimerCategorie")
	public String supprimerCategorie(@RequestParam("id") Long id,
			ModelMap modelMap, 
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size)
	{
		categorieService.deleteCategorieById(id);
		Page<Categorie> cats = categorieService.getAllCategoriesParPage(page, size);

		modelMap.addAttribute("categories", cats);
		modelMap.addAttribute("pages", new int[cats.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeCategories";
	}
	
	
	@RequestMapping("/modifierCategorie")
	public String editerCategorie(@RequestParam("id") Long id, ModelMap modelMap ) {
		Categorie c = categorieService.getCategorie(id);
		modelMap.addAttribute("categorie", c);
		
		//List<Genre> cats= categorieService.getAllCategories();
		//modelMap.addAttribute("categories", cats);
		
		modelMap.addAttribute("mode", "edit");
		return "formCategorie";
	}
	
	@RequestMapping("/creerCategorie")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("categorie", new Categorie());
		
		modelMap.addAttribute("mode", "new");
		return "formCategorie";
	}
	
	
	@RequestMapping("/saveCategorie")
	public String saveCategorie(@Valid Categorie categorie, BindingResult bindingResult)

	{
		if (bindingResult.hasErrors()) 
			return "formCategorie";

		categorieService.saveCategorie(categorie);
		
		return "redirect:/ListeCategories";
		}


}
