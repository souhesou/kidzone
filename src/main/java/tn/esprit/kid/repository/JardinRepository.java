package tn.esprit.kid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.kid.entities.Jardin;

public interface JardinRepository extends CrudRepository<Jardin,Integer> {
	
	@Query("SELECT j FROM Jardin j where j.Zone like %:Adresse% ")
	List<Jardin> findJardinByZone(@Param("Adresse")  String Adresse);
	
}
