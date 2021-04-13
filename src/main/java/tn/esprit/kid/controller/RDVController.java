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

import tn.esprit.kid.entities.RDV;
import tn.esprit.kid.services.IFactureService;
import tn.esprit.kid.services.IRDVService;

@RestController
@RequestMapping("/rdv")
public class RDVController {
	
	@Autowired
	IRDVService rdvservice;
	@Autowired
	IFactureService factureservice;
	
	@Autowired
	
	
	
//////////////////////	
@GetMapping("/retrieve-all-rdv")
@ResponseBody
public List<RDV> getRdvs() {
	List<RDV> list = rdvservice.afficherAllRDV();
	return list;
}	


////////////////////////////

// http://localhost:8081/SpringMVC/servlet/add-facture
@PostMapping("/add-rdv")
@ResponseBody
public int addRDV(@RequestBody RDV R) {
return rdvservice.ajouterRDV(R);
}


//http://localhost:8089/SpringMVC/servlet/remove-facture/{id_rdv}

@DeleteMapping("/remove-facture/{id_rdv}")
@ResponseBody 
public void supprimerRDV(@PathVariable("id_rdv") int id_rdv) 

{ rdvservice.supprimerRDV(id_rdv); 

}







	

}
