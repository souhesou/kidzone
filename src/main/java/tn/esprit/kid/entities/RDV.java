package tn.esprit.kid.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//YOUSSEF_BJ//

@Entity
@Table(name = "RDV")
public class RDV implements Serializable {

	private Jardin jardin;
	private User user;

	public RDVPK getRdvpk() {
		return rdvpk;
	}

	// ASSOCIATION//
	// RDV <---> USER /YOUSSEF_BJ/
	////////////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	// RDV <---> Jardin //YOUSSEF_BJ//
	////////////////////////////////////////////////

	@ManyToOne
	@JoinColumn(name = "id_jardin", referencedColumnName = "id_jardin", insertable = false, updatable = false)
	public Jardin getJardin() {
		return jardin;
	}

	@EmbeddedId
	private RDVPK rdvpk;

	// GETTER-SETTER//
	////////////////////////////////////////////////

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRdvpk(RDVPK rdvpk) {
		this.rdvpk = rdvpk;
	}

}
