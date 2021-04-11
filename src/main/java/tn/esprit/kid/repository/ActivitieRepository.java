package tn.esprit.kid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.kid.entities.Activitie;

@Repository
public interface ActivitieRepository extends CrudRepository<Activitie, Integer>{


}
