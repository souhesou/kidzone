package tn.esprit.kid.controller;

import java.util.List;
import java.util.Optional;

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
	
	

	
//http://localhost:8081/retrieve-all-rdv
@GetMapping("/retrieve-all-rdv")
@ResponseBody
public List<RDV> getRdvs() {
	List<RDV> list = rdvservice.afficherAllRDV();
	return list;
}	

//http://localhost:8081/SpringMVC/servlet/rdv/retrieve-rdv/{idPK}
@GetMapping("/retrieve-rdv/{idPK}")
@ResponseBody
public Optional<RDV> getRdvsbyid(@PathVariable("idPK") int idPK) {
	Optional<RDV> list = rdvservice.getRDVById(idPK);
			return list;
}

////////////////////////////

// http://localhost:8081/SpringMVC/servlet/rdv/add-rdv
@PostMapping("/add-rdv")
@ResponseBody
public int addRDV(@RequestBody RDV R) {
return rdvservice.ajouterRDV(R);
}


//http://localhost:8081/SpringMVC/servlet/rdv/remove-rdv/{id_rdv}

@DeleteMapping("/remove-rdv/{id_rdv}")
@ResponseBody 
public void supprimerRDV(@PathVariable("id_rdv") int id_rdv) 

{ rdvservice.supprimerRDV(id_rdv); 

}







	

}
