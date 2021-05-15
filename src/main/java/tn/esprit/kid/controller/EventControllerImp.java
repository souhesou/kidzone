package tn.esprit.kid.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.services.IEnfantService;
import tn.esprit.kid.services.IEvenementService;


@Scope(value = "session")
@Controller(value = "eventController")
@ELBeanName(value = "eventController")
@Join(path = "/", to = "/login.jsf")
public class EventControllerImp {
	@Autowired
	IEvenementService eventservice;
	
	@Autowired
	IEnfantService enfantservice;
	

	private String Nom; private String lieu; private Date date;
	private int nbrParticipant; private String description;
	private List<Enfant> enfants ;
	private List<Evenement> events = new ArrayList<Evenement>();
	private Evenement event ; 
	private Integer eventIdToBeUpdated;
	private Enfant enfant; 
	private String word ;
	
	private int id ;
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	public Integer getEventIdToBeUpdated() {
		return eventIdToBeUpdated;
	}
	public void setEventIdToBeUpdated(Integer eventIdToBeUpdated) {
		this.eventIdToBeUpdated = eventIdToBeUpdated;
		
		
		
	}
	public void setEvent(Evenement event) {
		this.event = event;
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
	
	
	@GetMapping(value="/participants")
	@ResponseBody
	public List<Enfant> getEnfants( @RequestParam int idEvent) {
		String navigateTo = "null";
		navigateTo = "participants?idEvent="+idEvent;
		//System.out.println(idEvent);
		return enfantservice.getEnfantByid(idEvent);
	}
	
/*public List <Enfant> getts ()
{
	return enfantservice.afficherEnfant();
}*/
	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
	
	
	
	public List<Evenement> getEvent() {
		return eventservice.afficherEvent();
		}
	
	
	public List<Evenement> getEvents() {
		if (word== null){
		events = eventservice.getAllEvents();}
		else {
			events=eventservice.Search(word);
		}
		
		return events;
	}
	
	public void setEvents(List<Evenement> events) {
		this.events = events;
	}
	
	
	
	public EventControllerImp() {
		super();
	}
	public EventControllerImp(String nom, String lieu, Date date, int nbrParticipant, String description) {
		super();
		Nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.nbrParticipant = nbrParticipant;
		this.description = description;
	}

	
	
	
	public EventControllerImp(String nom, String lieu, Date date, int nbrParticipant, String description,
			Integer eventIdToBeUpdated) {
		super();
		Nom = nom;
		this.lieu = lieu;
		this.date = date;
		this.nbrParticipant = nbrParticipant;
		this.description = description;
		this.eventIdToBeUpdated = eventIdToBeUpdated;
	}
	public void addEvent() {
		eventservice.ajouterEvent(new Evenement (Nom, lieu, date, nbrParticipant, description));
		}
	
	public void removeEvent(int idEvent)
	{
	eventservice.remove(idEvent);
	}
	
	public void updateEvent()
	{ 
		eventservice.updateEvent(new Evenement (eventIdToBeUpdated,Nom, lieu, date, nbrParticipant, description));
	}

	
	public List<Evenement> Search(String word) {
	

		return eventservice.Search(word);
	}
	
	public void displayEvent(Evenement evn)
	{
	this.setNom(evn.getNom());
	this.setLieu(evn.getLieu());
	this.setDate(evn.getDate());
	this.setNbrParticipant(evn.getNbrParticipant());
	this.setDescription(evn.getDescription());
	this.setEventIdToBeUpdated(evn.getId());
	}

	
}
