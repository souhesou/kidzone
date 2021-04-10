package tn.esprit.kid.services;

import java.util.List;

import tn.esprit.kid.entities.Enfant;

public interface IEnfantService {


	public Enfant ajouterEnfant(Enfant enfant);

	public void affecterEnfantEvent(int idEnfant, int idEvent);

	List<Enfant> afficherEnfant();


	void remove(int idEnfant);
	Enfant updateEnfantt(int idEnfant, Enfant enfant);

	//Optional<CommentPost> getById(int idpostcomment);


	
}
