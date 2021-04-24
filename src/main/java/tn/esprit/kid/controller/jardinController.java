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

import tn.esprit.kid.entities.Jardin;
import tn.esprit.kid.services.IJardinService;

@RestController
@RequestMapping("/jardin")
public class jardinController {
	@Autowired
	IJardinService ij;
	
	@PostMapping("/")
	@ResponseBody
	public Jardin addJardin(@RequestBody Jardin jardin) {
		Jardin jardin1 = ij.ajouterJardin(jardin);
		return jardin1;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeJardin(@PathVariable("id") int id) {

		ij.supprimer(id);
	}
	@GetMapping("/")
	public List<Jardin> getAllJardin() {
		return this.ij.afficherJardin();
	}
	@PutMapping("/{id}")
	@ResponseBody
	public Jardin updateJardin(@PathVariable int id, @RequestBody Jardin jardin) {
		return ij.updateJardin(id, jardin);
	}
	
	
}
