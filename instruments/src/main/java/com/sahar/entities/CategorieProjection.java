package com.sahar.entities;

import org.springframework.data.rest.core.config.Projection;



@Projection(name = "nomCa", types = { Categorie.class })
public interface CategorieProjection {
	public String getNomCategorie();
}
