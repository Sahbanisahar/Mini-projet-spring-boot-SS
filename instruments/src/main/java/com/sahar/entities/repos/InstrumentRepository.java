package com.sahar.entities.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahar.entities.Categorie;
import com.sahar.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

	
	
	List<Instrument> findByNomInstrument(String nomInstrument);
	

	List<Instrument> findByNomInstrumentContains(String nomInstrument);
	
	
	
	@Query("select l from Instrument l where l.categorie = ?1")
	List<Instrument> findByCategorie(Categorie categorie);
	
	List<Instrument> findByCategorieIdCat(Long id);
	
	
	
	
	
	
	
	
	
	
	
	
		@Query("select b from Instrument b where b.nomInstrument like %?1 and b.prixInstrument > ?2")
		List<Instrument> findByNomPrix (String nom, Double prix);

		
		
		
		List<Instrument> findByOrderByNomInstrumentAsc();
		
		@Query("select b from Instrument b order by b.nomInstrument ASC, b.prixInstrument DESC")
		List<Instrument> trierInstrumentsNomsPrix ();
}
