package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.kid.entities.Activitie;
import tn.esprit.kid.repository.ActivitieRepository;

public class ActivitieService implements IActivitieService {
	@Autowired
	ActivitieRepository iec;
	
	
	@Override
	public Activitie ajouterActivitie(Activitie activitie) {
		return iec.save(activitie) ;
	}

	@Override
	public List<Activitie> afficherActivitie() {
		return (List<Activitie>) this.iec.findAll();
	}

	@Override
	public void remove(int idAct) {
		iec.deleteById(idAct);
		
	}

	@Override
	public Activitie updateActivitie(int idAct, Activitie activitie) {
		Activitie act = new Activitie();
		Optional<Activitie> act2 = this.iec.findById(idAct);
		if (act2.isPresent()) {
			Activitie finded = act2.get();
			finded = activitie;
			act = this.iec.save(finded);
		}
		return act;
		
	}

	@Override
	public Optional<Activitie> getById(int idAct) {
		return this.iec.findById(idAct);
		
	}
	
	
	

}
