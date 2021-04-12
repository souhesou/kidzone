package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jardin implements Serializable {
			// tester souhheeeee


	
	/// Association One TO Many (Facture) YOUSSEF_BJ//
@OneToMany(mappedBy = "jardin")
private List<Facture> Facture;
////////////////////////////////////////////////
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_jardin")
private int id_jardin;

			// ATTRIBUT//

	












	
}
