package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.Activitie;


public interface IActivitieService {

	public Activitie ajouterActivitie(Activitie activitie);

	public List<Activitie> afficherActivitie();

	public void remove(int idAct);
	
	public Activitie updateActivitie(int idAct, Activitie activitie);

	Optional<Activitie> getById(int idAct);
	
	
}
