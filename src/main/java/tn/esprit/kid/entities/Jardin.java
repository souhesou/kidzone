package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Jardin implements Serializable {
	private static final long serialVersionUID = 6783200708580771172L;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	private int id;
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
