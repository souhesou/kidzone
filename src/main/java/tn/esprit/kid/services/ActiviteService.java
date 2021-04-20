package tn.esprit.kid.services;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Activitie;
import tn.esprit.kid.repository.ActiviteRepository;

@Service
public class ActiviteService implements IActiviteService {
	@Autowired
	ActiviteRepository iac ; 


	@Override
	public Activitie ajouterActivite(Activitie act) {
		// TODO Auto-generated method stub
		return iac.save(act);
	}

	@Override
	public Set<Activitie> afficherActivite() {
		return (Set<Activitie>) this.iac.findAll();

	}

	@Override
	public void remove(int idAct) {
		iac.deleteById(idAct);
	}

	@Override
	public Activitie updateActivite(int idAct, Activitie act) {
		Activitie activite = new Activitie ();
		Optional<Activitie> activite2= this.iac.findById(idAct);
		if (activite2.isPresent()) {
			Activitie finded = activite2.get();
			finded = act;
			activite = this.iac.save(finded);
		}
		return activite;
	}

	@Override
	public Optional<Activitie> getById(int idAct) {
		return this.iac.findById(idAct);
	}
	
	
	

}
