package tn.esprit.kid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.kid.services.IRDVService;

@RestController
@RequestMapping("/rdv")
public class RDVController {
	
	@Autowired
	IRDVService rdvservice;
	
	
	
	
	
	

}
