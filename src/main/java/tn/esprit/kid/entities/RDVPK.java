package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RDVPK implements Serializable{

	
	private int id_jardin;
	private int id_user;

	private String description;
	
	
	@Temporal(TemporalType.DATE)
	private Date daterdv;
	
}
