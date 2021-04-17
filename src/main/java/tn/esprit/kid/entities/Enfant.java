package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Enfant implements Serializable {
	private static final long serialVersionUID = 6783200708580771172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Nom;
	private String Prenom;
	private int age;
	private String niveau;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "enfants", cascade = CascadeType.REMOVE)
	private List<Evenement> events = new ArrayList<Evenement>();
	
	@JsonIgnore
	//@LazyCollection(LazyCollectionOption.FALSE)
	//@ManyToMany(mappedBy = "enfant", cascade = CascadeType.REMOVE)
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "enfant", cascade = CascadeType.REMOVE)
	private Set<Activitie> activites = new TreeSet<Activitie>();
	
	public Enfant(String nom, String prenom, int age, String niveau) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.age = age;
		this.niveau = niveau;
	}
	
	public Enfant() {
		super();
	}
	

	public Set<Activitie> getActivites() {
		return activites;
	}

	public void setActivites(Set<Activitie> activites) {
		this.activites = activites;
	}

	public List<Evenement> getEvents() {
		return events;
	}

	public void setEvents(List<Evenement> events) {
		this.events = events;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	
	
}
