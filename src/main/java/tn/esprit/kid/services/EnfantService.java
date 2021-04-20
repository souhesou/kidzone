package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Activitie;
import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.repository.ActiviteRepository;
import tn.esprit.kid.repository.EvenementRepository;
import tn.esprit.kid.repository.enfantRepository;

@Service
public class EnfantService implements IEnfantService {
	@Autowired
	enfantRepository ie;
	@Autowired
	EvenementRepository iev;
	@Autowired
	ActiviteRepository iac ;
	
	@Autowired
	private EmailService service ; 
	
	@Override
	public Enfant ajouterEnfant(Enfant enfant) {
		return ie.save(enfant) ;
	}

	
	
	@Override
	public void affecterEnfantActivite(int idEnfant, int idAct) {
		Enfant enfant = ie.findById(idEnfant).orElse(null);
		Activitie act = iac.findById(idAct).orElse(null);
		act.getEnfant().add(enfant);
		iac.save(act);
		
	}



	@Override
	public void affecterEnfantEvent(int idEnfant, int idEvent) {
		Enfant enfant = ie.findById(idEnfant).orElse(null);
		Evenement event = iev.findById(idEvent).orElse(null);
		event.getEnfants().add(enfant);
		iev.save(event);	
	   service.sendSimpleEmail("souha.saada@esprit.tn", "l'enfant "+enfant.getNom()+" est inscrit à l'evenement"+" "+event.getNom()+" avec succès qui aura lieu le "+" "+event.getDate()+" "+"à "+event.getLieu(), "event");

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



	@Override
	public List<Enfant> TriByName() {
		return ie.TriByName();
	}



	@Override
	public List<Enfant> Search(String word) {
		return (List<Enfant>) ie.searchEnfant(word);
	}
 
	
	

}
