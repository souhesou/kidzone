package tn.esprit.kid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Integer> {
	
	@Query(value="SELECT * FROM evenement Order By nom",nativeQuery =true)
	public List<Evenement> FindEventByName();
}
