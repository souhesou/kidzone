package tn.esprit.kid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture,Integer>{

}
