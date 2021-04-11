package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.repository.enfantRepository;

@Service
public class EnfantService implements IEnfantService {
	@Autowired
	enfantRepository ie;
	@Override
	public Enfant ajouterEnfant(Enfant enfant) {
		return ie.save(enfant) ;
	}

	@Override
	public void affecterEnfantEvent(int idEnfant, int idEvent) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return this.ie.findById(idEnfant);
	}
 

}
