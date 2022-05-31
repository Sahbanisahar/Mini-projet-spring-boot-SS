package com.sahar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sahar.entities.Categorie;
import com.sahar.entities.repos.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {
	
	@Autowired
	CategorieRepository categorieRepository;

	@Override
	public Categorie saveCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorieRepository.save(c);
	}

	@Override
	public Categorie updateCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return categorieRepository.save(c);
	}

	@Override
	public void deleteCategoriet(Categorie c) {
		// TODO Auto-generated method stub
		categorieRepository.delete(c);
	}

	@Override
	public void deleteCategorieById(Long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

	@Override
	public Categorie getCategorie(Long id) {
		// TODO Auto-generated method stub
		return categorieRepository.findById(id).get();
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return categorieRepository.findAll();
	}

	@Override
	public Page<Categorie> getAllCategoriesParPage(int page, int size) {
		// TODO Auto-generated method stub
		return categorieRepository.findAll(PageRequest.of(page, size));
	}

}
