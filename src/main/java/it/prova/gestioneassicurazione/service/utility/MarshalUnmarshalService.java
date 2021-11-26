package it.prova.gestioneassicurazione.service.utility;

import java.io.File;
import java.util.List;

import it.prova.gestioneassicurazione.generated.Assicurati;

public interface MarshalUnmarshalService {
	
	public List<Assicurati.Assicurato> unmarshal(File file);
	
	public void marshal(Assicurati assicurati, File file);

}
