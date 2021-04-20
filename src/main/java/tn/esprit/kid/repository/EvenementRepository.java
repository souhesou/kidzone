package tn.esprit.kid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Integer> {
	
	@Query(value="SELECT * FROM evenement Order By nom",nativeQuery =true)
	public List<Evenement> FindEventByName();
	
	
	/*
	@Query("SELECT * from Evenement e join Enfant f on  where e.nom like %:word% or e.date like %:word% or"
			+ " e.description like %:word% or e.lieu like %:word% or e.nbr_participant like %:word%")
	public List<Evenement> searchEvent(@Param("word") String word);
	*/
	
}
