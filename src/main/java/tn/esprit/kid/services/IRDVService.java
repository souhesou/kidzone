package tn.esprit.kid.services;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.RDV;



public interface IRDVService {
	
	public int ajouterRDV(RDV rdv);
	public void ajouterRDV2(int id_user, int id_jardin,  String description, Date daterdv);
	
	public void supprimerRDV(int id_user);

	public RDV modifierRDV(int id_RDV, RDV rdv);

	public List<RDV> afficherAllRDV();

	public Optional<RDV> getAll_RDV_by_JARDIN(int id_jardin);

	Optional<RDV> getRDVById(int id_RDV);

}
