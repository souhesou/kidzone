package tn.esprit.kid.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Evenement  implements Serializable {
	private static final long serialVersionUID = 6783200708580771172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nom;
	private String lieu;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int nbrParticipant;
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<Enfant> enfants = new ArrayList<Enfant>();

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
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbrParticipant() {
		return nbrParticipant;
	}
	public void setNbrParticipant(int nbrParticipant) {
		this.nbrParticipant = nbrParticipant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Evenement() {
		super();
	}
	public Evenement(String nom, String lieu, Date date, int nbrParticipant, String description) {
		super();
		Nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.nbrParticipant = nbrParticipant;
		this.description = description;
	}
	
	

}
