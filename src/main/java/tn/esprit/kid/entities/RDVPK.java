package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RDVPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// 4 cle primaire RDV
	
	public int id_jardin;
	
	public int id_user;
	
	public String description;
	
	@Temporal(TemporalType.DATE)
	private Date daterdv;

	public int getId_jardin() {
		return id_jardin;
	}

	public void setId_jardin(int id_jardin) {
		this.id_jardin = id_jardin;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDaterdv() {
		return daterdv;
	}

	public void setDaterdv(Date daterdv) {
		this.daterdv = daterdv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((daterdv == null) ? 0 : daterdv.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id_jardin;
		result = prime * result + id_user;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RDVPK other = (RDVPK) obj;
		if (daterdv == null) {
			if (other.daterdv != null)
				return false;
		} else if (!daterdv.equals(other.daterdv))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_jardin != other.id_jardin)
			return false;
		if (id_user != other.id_user)
			return false;
		return true;
	}

	public RDVPK(){
		
	}
	
	public RDVPK(int id_jardin, int id_user, String description, Date daterdv) {
		super();
		this.id_jardin = id_jardin;
		this.id_user = id_user;
		this.description = description;
		this.daterdv = daterdv;
	}

	
//////
//////
//////getter setter hashcode equals constructor

	

	
	
	
	

}
