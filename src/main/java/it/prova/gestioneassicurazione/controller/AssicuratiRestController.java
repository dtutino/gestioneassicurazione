package it.prova.gestioneassicurazione.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurazione.model.Assicurato;
import it.prova.gestioneassicurazione.service.assicurati.AssicuratiService;
import it.prova.gestioneassicurazione.service.file.FileProcessingService;


	
@RestController
@RequestMapping("/assicurato")
public class AssicuratiRestController {
		
	@Autowired
	public AssicuratiService assicuratiService;
	@Autowired
	FileProcessingService fileService;

	@GetMapping("")
	public String trigger() {

		fileService.processFile();
		
		return "ok";
	}

	@GetMapping("/list")
	public List<Assicurato> getAll() {
		return assicuratiService.listAll();
	}

}


