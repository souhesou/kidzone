package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

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
	private Set<Enfant> enfant = new TreeSet<Enfant>();
	
	


	public Activitie(String nom, String description, String type, Date date) {
		super();
		Nom = nom;
		this.description = description;
		this.type = type;
		this.date = date;
	}

	public Activitie() {
		super();
	}

	
	
	
	public Set<Enfant> getEnfant() {
		return enfant;
	}

	public void setEnfant(Set<Enfant> enfant) {
		this.enfant = enfant;
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

	
	
	
	

}
