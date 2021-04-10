package tn.esprit.kid.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return ie.save(enfant) ;
	}

	@Override
	public void affecterEnfantEvent(int idEnfant, int idEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enfant> afficherEnfant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(int idEnfant) {
		// TODO Auto-generated method stub
		ie.deleteById(idEnfant);
	}

	@Override
	public Enfant updateEnfantt(int idEnfant, Enfant enfant) {
		// TODO Auto-generated method stub
		return null;
	}

}
