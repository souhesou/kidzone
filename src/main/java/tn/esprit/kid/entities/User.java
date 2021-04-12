package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.springframework.security.core.userdetails.UserDetails;
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 6783200708580771172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nom;
	private String Prenom;
	private String userName; 
	private String Password ; 
	@Enumerated(EnumType.STRING)
    private Roles Role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Reclamation>Reclamations; 
	
	public List<Reclamation> getReclamations() {
		return Reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		Reclamations = reclamations;
	}

	public User() {
	    super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return userName;
	}
	public void setUserName(String userName) {
		userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Roles getRole() {
		return Role;
	}
	public void setRole(Roles role) {
		Role = role;
	}
	
	public UserDetails toCurrentUserDetails() {
	    return MyUserDetails.create(this);
	}

}
