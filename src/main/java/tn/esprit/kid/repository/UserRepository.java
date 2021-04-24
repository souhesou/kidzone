package tn.esprit.kid.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUserName(String username);
	
}
