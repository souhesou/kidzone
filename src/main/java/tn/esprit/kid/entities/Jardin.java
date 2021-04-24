package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Jardin implements Serializable {
	private static final long serialVersionUID = 6783200708580771172L;
	/// Association One TO Many (Facture) YOUSSEF_BJ//
		@OneToMany(mappedBy = "jardin")
		private List<Facture> Facture;

		////////////////////////////////////////////////
		// many to many <----> jardin and user
		@Transient
		private List<RDV> rdvs;

		@OneToMany(mappedBy = "id_jardin", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
		public List<RDV> getRdvs() {
			return rdvs;
		}
		////////////////////////////////////////////////
		@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jardin", cascade = CascadeType.REMOVE)
		private List<Enfant> enfants = new ArrayList<Enfant>();
		
		@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jardin", cascade = CascadeType.REMOVE)
		private List<User> users = new ArrayList<User>();
	public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}

	public List<Enfant> getEnfants() {
			return enfants;
		}

		public void setEnfants(List<Enfant> enfants) {
			this.enfants = enfants;
		}

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
