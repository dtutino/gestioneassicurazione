package it.prova.gestioneassicurazione.service.assicurati;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurazione.model.Assicurato;
import it.prova.gestioneassicurazione.repository.AssicuratiRepository;

@Service
public class AssicuratiServiceImpl implements AssicuratiService {
	
	@Autowired
	private AssicuratiRepository repo;
	
	@Override
	public List<Assicurato> listAll() {
		return (List<Assicurato>) repo.findAll();
	}
	
	@Override
	public boolean addOrUpdate(List<Assicurato> assicurati) {
		for (Assicurato assicurato : assicurati) {			
			Assicurato temp = repo.findByCodiceFiscale(assicurato.getCodiceFiscale());
			
			if(temp != null) {
				temp.setNumeroSinistri(temp.getNumeroSinistri() + assicurato.getNumeroSinistri());
				repo.save(temp);
			}else {
				repo.save(temp);
			}
		}
		return true;
	}

}
