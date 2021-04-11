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

import tn.esprit.kid.entities.Activitie;
import tn.esprit.kid.services.IActivitieService;

@RestController
@RequestMapping("/activitie")
public class ActivitieController {
	@Autowired
	IActivitieService iec;
	
	
	@PostMapping("/")
	@ResponseBody
	public Activitie addActivitie(@RequestBody Activitie act) {
		Activitie act1 = iec.ajouterActivitie(act);
		return act1;
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeActivitie(@PathVariable("id") int id) {
		iec.remove(id);
	}
	
	@GetMapping("/")
	public List<Activitie> getAllActivitie() {
		return this.iec.afficherActivitie();
	}
	
	
	@PutMapping("/{id}")
	@ResponseBody
	public Activitie updateActivitie(@PathVariable int id, @RequestBody Activitie act) {
		return iec.updateActivitie(id, act);
	}
	
	
	
	

}
