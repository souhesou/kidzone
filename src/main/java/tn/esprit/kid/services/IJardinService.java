package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.Jardin;

public interface IJardinService {
	
	public Jardin ajouterJardin(Jardin jardin);
	public List<Jardin> afficherJardin();
	public void supprimer (int id);
	public Jardin updateJardin (int id, Jardin jardin);
	Optional<Jardin> getById(int id);
	
	
	
}
