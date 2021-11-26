package it.prova.gestioneassicurazione.service.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurazione.generated.Assicurati;

@Service
public class MarshalUnmarshalServiceImpl implements MarshalUnmarshalService {

	@Override
	public List<Assicurati.Assicurato> unmarshal(File file) {
		JAXBContext jaxbContext;
		Assicurati ass = null;
		try {
			jaxbContext = JAXBContext.newInstance(Assicurati.class);
			Unmarshaller jaxbUnmarshaller = null;
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ass = (Assicurati) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return ass.getAssicurato();
	}

	@Override
	public void marshal(Assicurati assicurati, File file) {
		try {
			JAXBContext contextObj = JAXBContext.newInstance(Assicurati.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(assicurati, new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
