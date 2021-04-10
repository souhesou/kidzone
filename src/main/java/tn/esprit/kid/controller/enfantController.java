package tn.esprit.kid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void removeCommentPost(@PathVariable("id") int id) {

		ie.remove(id);
	}
	


}
