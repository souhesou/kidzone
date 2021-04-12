package tn.esprit.kid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.RDV;

@Repository
public interface RDVRepository extends CrudRepository<RDV,Integer>{

}
