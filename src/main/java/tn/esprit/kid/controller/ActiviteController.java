package tn.esprit.kid.controller;

import java.util.Set;

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

import tn.esprit.kid.entities.Activitie;
import tn.esprit.kid.services.IActiviteService;

@RestController
@RequestMapping("/activite")
public class ActiviteController {
	
	@Autowired
	IActiviteService iac;
	
	
	@PostMapping("/")
	@ResponseBody
	public Activitie addAct(@RequestBody Activitie actv) {
		Activitie actv1 = iac.ajouterActivite(actv);
		return actv1;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeAct(@PathVariable("id") int id) {

		iac.remove(id);
	}

	@GetMapping("/")
	public Set<Activitie> getAllAct() {
		return this.iac.afficherActivite();
	}
	
	
	@PutMapping("/{id}")
	@ResponseBody
	public Activitie updateAct(@PathVariable int id, @RequestBody Activitie act) {
		return iac.updateActivite(id, act);
	}
}
