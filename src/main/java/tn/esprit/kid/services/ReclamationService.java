package tn.esprit.kid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Jardin;
import tn.esprit.kid.entities.Reclamation;
import tn.esprit.kid.repository.JardinRepository;
import tn.esprit.kid.repository.ReclamationRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ReclamationService {
	
	
	@Autowired
	ReclamationRepository rep ; 
	@Autowired
	JardinRepository repjardin;
	
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
	
	
	public List<Reclamation> GetBadReclamationByJardin( int id ){
		
		return rep.GetBadReclamationByJardin( id );
		
		
	}
	
	public void suggestion(List<Jardin>ListJardin){
		
		HashMap<String, String> Suggestion = new HashMap<String, String>();
		  
		ListJardin.forEach(j -> {
			long count = this.GetBadReclamationByJardin(j.getId()).stream().count();
			
			
			if( count == 0 ){
				System.out.println("Jardin : " + j.getId() + " BadReclamation = 0");
				
			}
			else { 
				
				System.out.println("Jardin : " + j.getId() + " BadReclamation = " + count);
				
			}
			
			Suggestion.put("Nom = " + String.valueOf(j.getNom()) + " Zone =" + j.getZone() , " Bad Rec = " + String.valueOf(count)  );
			 
		});
		Map<String, String> result = Suggestion.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		System.out.println(result);
	}
	

}
