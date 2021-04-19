package tn.esprit.kid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.services.IEnfantService;

@RestController
@RequestMapping("/enfant")
public class enfantController {

	@Autowired
	IEnfantService ie;
	
	@PostMapping("/")
	@ResponseBody
	public Enfant addEnfant(@RequestBody Enfant enfant) {
		Enfant enfant1 = ie.ajouterEnfant(enfant);
		return enfant1;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeEnfant(@PathVariable("id") int id) {

		ie.remove(id);
	}
	
	@GetMapping("/")
	public List<Enfant> getAllEnfant() {
		return this.ie.afficherEnfant();
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Enfant updateEnfant(@PathVariable int id, @RequestBody Enfant enfant) {
		return ie.updateEnfant(id, enfant);
	}
	
	
	@PostMapping("/affectationEV/{enfantsId}/{eventsId}")
	@ResponseBody
	public void  affecterEnfantEvent(@PathVariable("enfantsId") int enf, @PathVariable("eventsId") int evnt) {
		ie.affecterEnfantEvent(enf, evnt);
	}

	@PostMapping("/affectationAC/{enfantId}/{activitesId}")
	@ResponseBody
	public void  affecterEnfantAct(@PathVariable("enfantId") int enf, @PathVariable("activitesId") int act) {
		ie.affecterEnfantActivite(enf, act);
	}

}
