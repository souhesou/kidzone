package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.Enfant;

public interface IEnfantService {

	public Enfant ajouterEnfant(Enfant enfant);

	public void affecterEnfantEvent(int idEnfant, int idEvent);
	public void affecterEnfantActivite(int idEnfant, int idAct);

	public List<Enfant> afficherEnfant();

	public void remove(int idEnfant);

	public Enfant updateEnfant(int idEnfant, Enfant enfant);

	Optional<Enfant> getById(int idEnfant);
	
	public List<Enfant> TriByName();
	public List<Enfant> Search(String word);
	

}
