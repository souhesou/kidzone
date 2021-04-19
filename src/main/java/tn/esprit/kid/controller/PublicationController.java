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

import tn.esprit.kid.entities.Publication;
import tn.esprit.kid.services.IPublicationService;


@RestController
@RequestMapping("/publication")
public class PublicationController {

	
	@Autowired
	IPublicationService ie;
	
	@PostMapping("/")
	@ResponseBody
	public Publication addPublication(@RequestBody Publication pub) {
		Publication pub1 = ie.ajouterPub(pub);
		return pub1;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removePublication(@PathVariable("id") int id) {

		ie.remove(id);
	}
	
	@GetMapping("/")
	public List<Publication> getAllPublication() {
		return this.ie.afficherPub();
	}

	@PutMapping("/{id}")
	@ResponseBody
	public Publication updatePublication(@PathVariable int id, @RequestBody Publication pub) {
		return ie.updatePub(id, pub);
	}
	
	
	
	
}
