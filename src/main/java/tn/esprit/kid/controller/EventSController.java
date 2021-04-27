package tn.esprit.kid.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.services.IEvenementService;

@Scope(value = "session")
@Controller(value = "eventController") // Name of the bean in Spring IoC
@ELBeanName(value = "eventController") // Name of the bean used by JSF
@Join(path = "/", to = "/event.jsf")

public class EventSController {
	
	@Autowired
	IEvenementService iev;
	
	private String Nom; private String lieu; private Date date;
	private int nbrParticipant; private String description;
	private List<Enfant> enfants = new ArrayList<Enfant>();
	private List<Evenement> events;
	
	
	public List<Evenement> getEvents() {
		return events;
	}
	public void setEvents(List<Evenement> events) {
		this.events = events;
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
	public List<Enfant> getEnfants() {
		return enfants;
	}
	public void setEnfants(List<Enfant> enfants) {
		this.enfants = enfants;
	}
	
	public void addEvent() {
		iev.ajouterEvent(new Evenement (Nom, lieu, date, nbrParticipant, description));
		}
	
	public void removeEvent(int idEvent)
	{
	iev.remove(idEvent);
	}
	
	public void updateEvent(int idEvent)
	{ 
		iev.updateEvent(idEvent, new Evenement (Nom, lieu, date, nbrParticipant, description));
	}
	
	public List<Evenement> getEvent() {
		return iev.afficherEvent();
		}	
	
	
	public void displayEvent(Evenement evn)
	{
	this.setNom(evn.getNom());
	this.setLieu(evn.getLieu());
	this.setDate(evn.getDate());
	this.setNbrParticipant(evn.getNbrParticipant());
	this.setDescription(evn.getDescription());
	}



}
