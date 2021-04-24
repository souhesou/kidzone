package tn.esprit.kid.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.kid.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUserName(String username);
	
}
