package tn.esprit.kid.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

//YOUSSEF_BJ//

@Entity
@Table(name = "RDV")
public class RDV implements Serializable {

	@EmbeddedId
    private RDVPK id;
	
	
	
	
	@ManyToOne
    @MapsId("JardinId")
    @JoinColumn(name = "jardin_id")
    private Jardin jardin;
	
	@ManyToOne
    @MapsId("UserId")
    @JoinColumn(name = "user_id")
	private User user;

	public RDVPK getId() {
		return id;
	}

	public void setId(RDVPK id) {
		this.id = id;
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
	

}
