package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Jardin implements Serializable {
	// tester souhheeeee

	/// Association One TO Many (Facture) YOUSSEF_BJ//
	@OneToMany(mappedBy = "jardin")
	private List<Facture> Facture;

	////////////////////////////////////////////////
	// many to many <----> jardin and user
	@Transient
	private List<RDV> rdvs;

	@OneToMany(mappedBy = "id_jardin", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	public List<RDV> getRdvs() {
		return rdvs;
	}
	////////////////////////////////////////////////

	// ATTRIBUT//

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_jardin")
	private int id_jardin;

}
