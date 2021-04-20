package tn.esprit.kid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.kid.entities.Jardin;
import tn.esprit.kid.entities.Reclamation;

public interface ReclamationRepository extends CrudRepository<Reclamation, Integer>{

	@Query("SELECT r FROM Reclamation r JOIN r.jardin j where j.id = ?1 and r.Description like '%mauv%' ")
	List<Reclamation> GetBadReclamationByJardin(int id );

}
