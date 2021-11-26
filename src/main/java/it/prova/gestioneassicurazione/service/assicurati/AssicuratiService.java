package it.prova.gestioneassicurazione.service.assicurati;

import java.util.List;

import it.prova.gestioneassicurazione.model.Assicurato;

public interface AssicuratiService {
	
	public List<Assicurato> listAll();
	
	public boolean addOrUpdate(List<Assicurato> assicurati);

}
