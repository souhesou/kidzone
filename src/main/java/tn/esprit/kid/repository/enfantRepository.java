package tn.esprit.kid.repository;



import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Enfant;


@Repository
public interface enfantRepository extends CrudRepository<Enfant, Integer> {

	
	
	
	
	
}
