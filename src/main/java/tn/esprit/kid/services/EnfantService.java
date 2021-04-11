package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.repository.EvenementRepository;
import tn.esprit.kid.repository.enfantRepository;

@Service
public class EnfantService implements IEnfantService {
	@Autowired
	enfantRepository ie;
	@Autowired
	EvenementRepository iev;

	
	@Override
	public Enfant ajouterEnfant(Enfant enfant) {
		return ie.save(enfant) ;
	}

	
	
	@Override
	public void affecterEnfantEvent(int idEnfant, int idEvent) {
		Enfant enfant = ie.findById(idEnfant).orElse(null);
		Evenement event = iev.findById(idEvent).orElse(null);
		event.getEnfants().add(enfant);
		iev.save(event);	
	}

	
	
	@Override
	public List<Enfant> afficherEnfant() {
		return (List<Enfant>) this.ie.findAll();
	}

	
	@Override
	public void remove(int idEnfant) {
		ie.deleteById(idEnfant);
	}
	

	@Override
	public Enfant updateEnfant(int idEnfant, Enfant enfant) {
		Enfant enf = new Enfant();
		Optional<Enfant> enf2 = this.ie.findById(idEnfant);
		if (enf2.isPresent()) {
			Enfant finded = enf2.get();
			finded = enfant;
			enf = this.ie.save(finded);
		}
		return enf;
		
	}
	
	
	@Override
	public Optional<Enfant> getById(int idEnfant) {
		return this.ie.findById(idEnfant);
	}
 

}
