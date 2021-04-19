package tn.esprit.kid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Jardin;
import tn.esprit.kid.repository.JardinRepository;
import tn.esprit.kid.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository rep ; 
	@Autowired
	JardinRepository rep2 ;
	@Autowired
	ReclamationService serviceReclamation ; 
	
	public void findBestJardinForUserByAddress(String Adresse){
		List<Jardin> ListJardin = rep2.findJardinByZone(Adresse);
		serviceReclamation.suggestion(ListJardin);
		
	}

}
