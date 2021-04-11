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
public class Activitie implements Serializable {
	private static final long serialVersionUID = 6783200708580771172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nom;
	private String description;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<Enfant> enfants = new ArrayList<Enfant>();
	
	
	public Activitie(String nom, String description, String type, Date date, List<Enfant> enfants) {
		super();
		Nom = nom;
		this.description = description;
		this.type = type;
		this.date = date;
		this.enfants = enfants;
	}

	public Activitie() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Enfant> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}

	
	
	
	

}
