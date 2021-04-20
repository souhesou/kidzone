package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.Evenement;

public interface IEvenementService {

	
	public Evenement ajouterEvent(Evenement event);

	public List<Evenement> afficherEvent();

	public void remove(int idEvent);
	
	public Evenement updateEvent(int idEvent, Evenement event);

	Optional<Evenement> getById(int idEvent);
	
	public List<Evenement> FindEventByName();
	
	public List<Evenement> Search(String word);
}
