package tn.esprit.kid.services;



import java.util.Optional;
import java.util.Set;

import tn.esprit.kid.entities.Activitie;

public interface IActiviteService {
	
	public Activitie ajouterActivite(Activitie act);

	public Set<Activitie> afficherActivite();

	public void remove(int idAct);
	
	public Activitie updateActivite(int idAct, Activitie act);

	Optional<Activitie> getById(int idAct);

}
