package tn.esprit.kid.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.services.IEnfantService;
import tn.esprit.kid.services.IEvenementService;

@Scope(value = "session")
@Controller(value = "enfantController")
@ELBeanName(value = "enfantController")
@Join(path = "/", to = "/login.jsf")
public class EnfantControllerImp {
	@Autowired
	IEnfantService enfantservice ; 
	@Autowired
	IEvenementService evenementservice ; 
	
	private String word ;
	private String nom; private String prenom; 
	private String nomEvents;
	private int age ; private String niveau ; 
	private Enfant enfant ; 
	private int idEvent;
	
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getIdEnfant() {
		return idEnfant;
	}
	
	public String getNomEvents() {
		return nomEvents;
	}
	public void setNomEvents(String nomEvents) {
		this.nomEvents = nomEvents;
	}
	public void setIdEnfant(int idEnfant) {
		this.idEnfant = idEnfant;
	}

	private int idEnfant;
	private List<Enfant> enfants;
	
	private Integer enfantIdToBeUpdated;
	
	private List<Evenement> events ;
	
	private Evenement event ; 
	
	public Evenement getEvent() {
		return event;
	}
	public void setEvent(Evenement event) {
		this.event = event;
	}
	public List<Evenement> getEvents() {
		return evenementservice.getAllEvents();
	}
	public void setEvents(List<Evenement> events) {
		this.events = events;
	}
	
	
	public Integer getEnfantIdToBeUpdated() {
		return enfantIdToBeUpdated;
	}
	public void setEnfantIdToBeUpdated(Integer enfantIdToBeUpdated) {
		this.enfantIdToBeUpdated = enfantIdToBeUpdated;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	public List<Enfant> getEnfants() {
		if (word== null){
			enfants = enfantservice.afficherEnfant();
		}
		else {
			enfants = enfantservice.Search(word);
		}
		return enfants ;
	}
	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
	public EnfantControllerImp() {
		super();
	}
	public EnfantControllerImp(String nom, String prenom, int age, String niveau) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.niveau = niveau;
	} 

	
	public void addEnfant() {
		enfantservice.ajouterEnfant(new Enfant(nom,prenom,age,niveau));
		}
	
	public void removeEnfant(int idEnfant)
	{
	enfantservice.remove(idEnfant);
	}
	
	
	public void affectation (){
		System.out.print("fffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		idEnfant=enfantservice.getidEnfant(nom);
		idEvent=evenementservice.getIdEvent(nomEvents).getId();
		System.out.print("hetha id event"+ idEvent);
		System.out.println(idEnfant+idEvent);

		enfantservice.affecterEnfantEvent(idEnfant, idEvent);
	}
	
	public List<String> getNomEnfant() {
		return enfantservice.getNomEnfant();
	}
	
	
	public List<String> getNomEvent(){
		return evenementservice.getNomEvent();
	}
	
	
	
	public List<Enfant> getEnfantt() {
		return enfantservice.afficherEnfant();
		}
	

	public void displayEnfant(Enfant en)
	{
	this.setNom(en.getNom());
	this.setPrenom(en.getPrenom());
	this.setAge(en.getAge());
	this.setNiveau(en.getNiveau());
	this.setEnfantIdToBeUpdated(en.getId());
	}
	
	
   public EnfantControllerImp(String nom, String prenom, int age, String niveau, Integer enfantIdToBeUpdated) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.niveau = niveau;
	    this.enfantIdToBeUpdated = enfantIdToBeUpdated;
	}
	public void updateEnfant()
	{ 
		//enfantservice.updateEnfant(new Enfant(nom,prenom,age,niveau) );
		enfantservice.updateEnfant(new Enfant(enfantIdToBeUpdated,nom,prenom,age,niveau) );
		}
	
	public String goAffect(){
		return "AffectEnfantEvent.xhtml?faces-redirect=true";
		
	}
	
	
	public List<Enfant> Search(String word) {

		return enfantservice.Search(word);
	}

	
}