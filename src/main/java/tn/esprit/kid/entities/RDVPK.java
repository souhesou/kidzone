package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RDVPK implements Serializable {

	private int id_jardin;
	private int id_user;

	@Temporal(TemporalType.DATE)
	private Date daterdv;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getJardinId() {
		return id_jardin;
	}

	public void setJardinId(int jardinId) {
		id_jardin = jardinId;
	}

	public int getUserId() {
		return id_user;
	}

	public void setUserId(int userId) {
		id_user = userId;
	}

	public Date getDaterdv() {
		return daterdv;
	}

	public void setDaterdv(Date daterdv) {
		this.daterdv = daterdv;
	}

	public RDVPK(int jardinId, int userId, Date daterdv) {
		super();
		id_jardin = jardinId;
		id_user = userId;
		this.daterdv = daterdv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_jardin;
		result = prime * result + id_user;
		result = prime * result + ((daterdv == null) ? 0 : daterdv.hashCode());
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
		if (id_jardin != other.id_jardin)
			return false;
		if (id_user != other.id_user)
			return false;
		if (daterdv == null) {
			if (other.daterdv != null)
				return false;
		} else if (!daterdv.equals(other.daterdv))
			return false;
		return true;
	}
	
	
	
	

}
