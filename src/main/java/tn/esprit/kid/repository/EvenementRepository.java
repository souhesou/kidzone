package tn.esprit.kid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Integer> {

}
