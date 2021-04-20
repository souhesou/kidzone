package tn.esprit.kid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Publication;
import tn.esprit.kid.entities.Reaction;
import tn.esprit.kid.entities.User;

@Repository
public interface ReactionRepository extends CrudRepository<Reaction, Integer> {

	Reaction findByUserAndPublication(User user, Publication publication);
	
	
}
