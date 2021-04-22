package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//YOUSSEF_BJ//

@Entity
@Table(name = "RDV")
public class RDV implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//attribut----correction--23-04-2021---youssef-bj
	@EmbeddedId
    private RDVPK idPK;
	
    private String description;
	
  //association----correction--23-04-2021--youssef-bj
	
	
	@ManyToOne
    @JoinColumn(name = "id_jardin", referencedColumnName = "id", insertable = false, updatable = false)
    private Jardin jardin;
	
	
	
	@ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	
	  //setter-getter----correction--23-04-2021--youssef-bj

	
	public RDVPK getId() {
		return idPK;
	}

	public void setId(RDVPK id) {
		this.idPK = id;
	}

	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RDVPK getIdPK() {
		return idPK;
	}

	public void setIdPK(RDVPK idPK) {
		this.idPK = idPK;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RDV(RDVPK idPK, String description, Jardin jardin, User user) {
		super();
		this.idPK = idPK;
		this.description = description;
		this.jardin = jardin;
		this.user = user;
	}

	public RDV() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RDV [idPK=" + idPK + ", description=" + description + ", jardin=" + jardin + ", user=" + user + "]";
	}
	
	
	
	
	

}
