package tn.esprit.kid.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//YOUSSEF_BJ//

@Entity
public class RDV implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;






	@EmbeddedId
	private RDVPK rdvpk;

	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="id_jardin",referencedColumnName= "id_jardin",insertable= false , updatable= false)
	private Jardin jardin;


	

	@ManyToOne
	@JoinColumn(name="id_user",referencedColumnName= "id_user",insertable= false , updatable= false )
	private User user;

	
	
	

	
	
	

}
