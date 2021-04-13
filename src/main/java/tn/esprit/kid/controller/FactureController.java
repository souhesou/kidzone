package tn.esprit.kid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.kid.entities.Facture;
import tn.esprit.kid.services.IFactureService;

@RestController
@RequestMapping("/facture")

public class FactureController {

	
	@Autowired
	IFactureService factureservice;
	
	
/////////a verifier//////////////	
	@GetMapping("/retrieve-all-facture")
	@ResponseBody
	public List<Facture> getFacture() {
		List<Facture> list = factureservice.afficherAllFacture();
		return list;
	}
	
////////////////////////////
	
	// http://localhost:8081/SpringMVC/servlet/add-facture
		@PostMapping("/add-facture")
		@ResponseBody
		public int addFacture(@RequestBody Facture f) {
			return factureservice.ajouterFacture(f);

		}
	
		
	//http://localhost:8089/SpringMVC/servlet/remove-employe/{id_facture}
		  
	      @DeleteMapping("/remove-facture/{id_facture}")
		  @ResponseBody 
		  public void supprimerEmploye(@PathVariable("id_facture") int id_facture) 
		  
		  { factureservice.supprimerFacture(id_facture); 
		  
		  }
		
}
