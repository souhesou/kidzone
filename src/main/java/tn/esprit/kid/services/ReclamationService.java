package tn.esprit.kid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Reclamation;
import tn.esprit.kid.repository.ReclamationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ReclamationService {
	
	
	@Autowired
	ReclamationRepository rep ; 
	
	public List<Reclamation> GetAllReclamations() {
		List<Reclamation> ListReclamations = new ArrayList<>();
		rep.findAll().forEach(e -> {
			ListReclamations.add(e);
		});
		
		return ListReclamations ;
	}
	
	public Optional<Reclamation> FindReclamationById(int id) {
		return rep.findById(id);
	}
	
	
	public void UpdateReclamation(Reclamation d) {
		// TODO Auto-generated method stub
		rep.save(d);
	}


	public void AddReclamation(Reclamation d) {
		rep.save(d);		
	}

	public void DeleteReclamation(int id) {
		// TODO Auto-generated method stub
		rep.deleteById(id);
	}

}
