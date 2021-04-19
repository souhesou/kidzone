package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class RDVPK implements Serializable{

	
	public int getJardinId() {
		return JardinId;
	}


	public void setJardinId(int jardinId) {
		JardinId = jardinId;
	}


	public int getUserId() {
		return UserId;
	}


	public void setUserId(int userId) {
		UserId = userId;
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


	@Column(name = "jardin_id")
    private int JardinId;

    @Column(name = "user_id")
    private int UserId;

	private String description;
	
	
	@Temporal(TemporalType.DATE)
	private Date daterdv;
	
}
