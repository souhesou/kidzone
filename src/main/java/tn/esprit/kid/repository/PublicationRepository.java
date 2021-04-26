package tn.esprit.kid.repository;

import org.springframework.data.repository.CrudRepository;


import tn.esprit.kid.entities.Publication;

public interface PublicationRepository extends CrudRepository<Publication, Integer> {

}
