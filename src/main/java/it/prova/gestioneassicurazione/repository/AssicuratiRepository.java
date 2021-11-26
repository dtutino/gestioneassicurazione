package it.prova.gestioneassicurazione.repository;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestioneassicurazione.model.Assicurato;

public interface AssicuratiRepository extends CrudRepository<Assicurato, Long> {
	
	public Assicurato findByCodiceFiscale(String codiceFiscale);

}
