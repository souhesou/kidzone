package tn.esprit.kid.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.kid.entities.Reclamation;
import tn.esprit.kid.services.ReclamationService;
import tn.esprit.kid.services.UserService;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
	
	@Autowired
	private ReclamationService service ; 
	
	@Autowired
	private UserService service2 ; 
	
	@RequestMapping("/")
	public List<Reclamation>GetAllReclamations(){
		
		return service.GetAllReclamations();
	}
	
	
	@RequestMapping("/{id}")
	public Optional<Reclamation> getEmployeById(@PathVariable int id) {
		return service.FindReclamationById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/add")
	public void AddReclamation(@RequestBody Reclamation e) {
		
		service.AddReclamation(e);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/{id}/update")
	public void UpdateReclamation(@RequestBody Reclamation e , @PathVariable int id ) {
		
		service.UpdateReclamation(e);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE , value="/{id}/delete")
	public void DeleteEmploye(@PathVariable int id ) {
		
		service.DeleteReclamation(id);
		
	}
	
	@RequestMapping("/test/{id}")
	public List<Reclamation>test(@PathVariable int id){
		//service.suggestion();
		
		service2.findBestJardinForUserByAddress("megrine");
		
		return service.GetBadReclamationByJardin(id);
		
	}
	

	

}
