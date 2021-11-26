package it.prova.gestioneassicurazione.service.file;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurazione.generated.Assicurati;
import it.prova.gestioneassicurazione.model.Assicurato;
import it.prova.gestioneassicurazione.service.assicurati.AssicuratiService;
import it.prova.gestioneassicurazione.service.utility.MarshalUnmarshalService;

@Service
public class FileProcessingServiceImpl implements FileProcessingService {

	@Autowired
	private MarshalUnmarshalService marshalService;
	@Autowired
	private AssicuratiService assicuratiService;
	
	@Value("${input-folder.path}")
	private String inputPath;	
	@Value("${output-folder.processed}")
	private String processedPath;	
	@Value("${output-folder.scarti}")
	private String scartiPath;	
	@Value("${file.path}")
	private String filePath;
	
	@Override
	public void processFile() {
		File inputFile = new File(inputPath + "\\" + filePath);
		File correctFile = new File(processedPath + "\\" + filePath);
		File badFile = new File(scartiPath + "\\" + filePath);

		List<Assicurati.Assicurato> assicurati = marshalService.unmarshal(inputFile);
		
		List<Assicurato> assicuratiModel = Assicurato.convertToModelList(assicurati);
		Assicurati assicuratiList = Assicurato.convertToAssicurati(assicuratiModel);
		
		for (Assicurato assicurato : assicuratiModel) {
			if(assicurato.getNumeroSinistri() < 0) {
				marshalService.marshal(assicuratiList, badFile);
				throw new RuntimeException("File non processato");
			}
		}
		
		if(!assicuratiService.addOrUpdate(assicuratiModel))
			throw new RuntimeException("Aggiornamento non riuscito");
		
		marshalService.marshal(assicuratiList, correctFile);
	}

}
