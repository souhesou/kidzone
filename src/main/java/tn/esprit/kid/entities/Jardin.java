package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jardin implements Serializable {
//////////////////////////////////////////////////////////////////////////////
	
	

	@JsonIgnore
	@OneToMany(mappedBy= "jardin")
	private List<RDV> rdvs;

	

	
	//////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	
	
	private static final long serialVersionUID = 6783200708580771172L;
	
	public int getId() {
		return id_jardin;
	}

	public void setId(int id) {
		this.id_jardin = id;
	}

	
	public List<Reclamation> getListReclamations() {
		return ListReclamations;
	}

	public void setListReclamations(List<Reclamation> listReclamations) {
		ListReclamations = listReclamations;
	}

	

	public String getZone() {
		return Zone;
	}

	public void setZone(String zone) {
		Zone = zone;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_jardin;
	private String Nom ; 
	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}






	private String Zone ; 
	
	
	
	@OneToMany(mappedBy = "jardin")
	private List<Reclamation> ListReclamations;
	


}
