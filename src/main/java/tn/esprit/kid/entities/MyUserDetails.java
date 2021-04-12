package tn.esprit.kid.entities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

public class MyUserDetails  implements UserDetails{
	
	
	private int id ; 
	private String Nom;
	private String Prenom;
	private String UserName; 
	private String Password ; 
	private Roles role ; 
	private List<Reclamation>ListReclamations ; 
	
	public List<Reclamation> getListReclamations() {
		return ListReclamations;
	}

	public void setListReclamations(List<Reclamation> listReclamations) {
		ListReclamations = listReclamations;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public MyUserDetails(User user){
		super();
		this.id = user.getId();
		this.Nom = user.getNom() ; 
		this.Prenom = user.getPrenom() ; 
		this.UserName = user.getUserName();
		this.Password = user.getPassword() ; 
		this.role = user.getRole();
		this.ListReclamations = user.getReclamations();
		
		
		
	}
	
	  @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

	        list.add(new SimpleGrantedAuthority(role.toString()));

	        return list;
	    }
	  
	  public static UserDetails create(User entity) {
		    return new MyUserDetails(entity);
		}
	  
	  
	  
	  

}
