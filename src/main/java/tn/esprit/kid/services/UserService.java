package tn.esprit.kid.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Jardin;
import tn.esprit.kid.entities.User;
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
	
	public void UpdateUser(User d) {
		// TODO Auto-generated method stub
		rep.save(d);
	}


	public void AddUser(User d) {
		rep.save(d);		
	}
	
	public List<User> GetAllUser() {
		List<User> ListUser = new ArrayList<>();
		rep.findAll().forEach(e -> {
			ListUser.add(e);
		});
		
		return ListUser ;
	}
	
	public Optional<User> FindUserById(int id) {
		return rep.findById(id);
	}
	
	public void DeleteUser(int id) {
		// TODO Auto-generated method stub
		rep.deleteById(id);
	}
	

}
