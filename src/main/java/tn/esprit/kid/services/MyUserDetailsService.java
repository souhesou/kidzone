package tn.esprit.kid.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.MyUserDetails;
import tn.esprit.kid.entities.User;
import tn.esprit.kid.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository rep ;
	
	@Override
	public UserDetails loadUserByUsername(String UserName) throws UsernameNotFoundException {
			
		if ( UserName == null || UserName.isEmpty() ){
	        throw new UsernameNotFoundException("username is empty");
	    }

	    User foundUser = rep.findByUserName(UserName);
	    if( foundUser != null ){
	        System.out.println("FOUND");
	        return foundUser.toCurrentUserDetails();

	    }
	    throw new UsernameNotFoundException( UserName + "is not found");
	}

}
