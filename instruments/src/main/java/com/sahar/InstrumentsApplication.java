package com.sahar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sahar.entities.Categorie;
import com.sahar.entities.Instrument;

@SpringBootApplication
public class InstrumentsApplication {
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(InstrumentsApplication.class, args);
	}
	
	
	public void run(String... args) throws Exception {
	/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
	produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
	produitService.saveProduit(new Produit("Imprimante Epson", 900.0, new Date()));*/
		repositoryRestConfiguration.exposeIdsFor(Instrument.class);
		repositoryRestConfiguration.exposeIdsFor(Categorie.class);
	}

}
