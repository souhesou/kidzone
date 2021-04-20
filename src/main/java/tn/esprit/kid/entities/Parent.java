package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@DiscriminatorValue("Parent")
@Entity
public class Parent extends User implements Serializable{
	private static final long serialVersionUID = 6783200708580771172L;
	
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="parent")
	@JsonIgnore
	private List<Enfant>ListEnfant ;

	public Parent(){
		super();
	}
	public List<Enfant> getListEnfant() {
		return ListEnfant;
	}


	public void setListEnfant(List<Enfant> listEnfant) {
		ListEnfant = listEnfant;
	} 
		
		
}
