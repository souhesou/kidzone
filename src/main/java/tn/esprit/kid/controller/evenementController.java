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

import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.services.IEvenementService;

@RestController
@RequestMapping("/event")
public class evenementController {
	
	@Autowired
	IEvenementService iev;

	
	@PostMapping("/")
	@ResponseBody
	public Evenement addEvent(@RequestBody Evenement event) {
		Evenement event1 = iev.ajouterEvent(event);
		return event1;
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeEvent(@PathVariable("id") int id) {

		iev.remove(id);
	}
	
	@GetMapping("/")
	public List<Evenement> getAllEvent() {
		return this.iev.afficherEvent();
	}
	

	@PutMapping("/{id}")
	@ResponseBody
	public Evenement updateEvent(@PathVariable int id, @RequestBody Evenement event) {
		return iev.updateEvent(id, event);
	}
	
	@GetMapping("/GetEventByName/")
	 @ResponseBody
	 public List<Evenement> FindEventByName() {
		return iev.FindEventByName();
		
	}
	
	/*
	@GetMapping("/search/{word}")
    @ResponseBody
	public List<Evenement> getevent(@PathVariable("word") String word) {
		
		return iev.Search(word);
	
	}*/
}
