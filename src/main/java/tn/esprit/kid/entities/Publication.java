package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Publication implements Serializable {
	private static final long serialVersionUID = 6783200708580771172L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Description;
	@Temporal(TemporalType.DATE)
	private Date date;
	private int NbrReaction;
	
	
	public String getTypeReaction() {
		return TypeReaction;
	}
	

	
	
	




	public Publication() {
		super();
	}




	




	public Publication(String description, Date date, int nbrReaction, String typeReaction) {
		super();
		Description = description;
		this.date = date;
		NbrReaction = nbrReaction;
		TypeReaction = typeReaction;
	}









	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
	}









	public Date getDate() {
		return date;
	}









	public void setDate(Date date) {
		this.date = date;
	}









	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public int getNbrReaction() {
		return NbrReaction;
	}
	public void setNbrReaction(int nbrReaction) {
		NbrReaction = nbrReaction;
	}
	public void setTypeReaction(String typeReaction) {
		TypeReaction = typeReaction;
	}
	private String TypeReaction;
}
