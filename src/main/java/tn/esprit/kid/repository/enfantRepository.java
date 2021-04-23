package tn.esprit.kid.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Enfant;


@Repository
public interface enfantRepository extends CrudRepository<Enfant, Integer> {

	@Query(value="SELECT * FROM enfant Order By nom",nativeQuery =true)
	public List<Enfant> TriByName();
	
	
	@Query(value="SELECT * from Enfant e where e.nom like %:word% or e.prenom like %:word% or"
			+ " e.age like %:word% or e.niveau like %:word%",nativeQuery =true)
	public List<Enfant> searchEnfant(@Param("word") String word);
	
	
	@Query(value="SELECT COUNT(events_id) FROM evenement_enfants where events_id =:idEvent",nativeQuery =true)
	public int counting(@Param("idEvent") int idEvent);
	
}
