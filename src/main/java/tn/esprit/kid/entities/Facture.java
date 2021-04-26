package tn.esprit.kid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ASSOCIATION//
	@ManyToOne
	private Jardin jardin;

	// ATTRIBUT//
	////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_facture")
	private int id_facture;

	private String description;
	private Date date_facture;
	private float prix;

	// SETTER-GETTER//
	////////////////////////////////////////////////
	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public int getId_facture() {
		return id_facture;
	}

	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_facture() {
		return date_facture;
	}

	public void setDate_facture(Date date_facture) {
		this.date_facture = date_facture;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_facture == null) ? 0 : date_facture.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id_facture;
		result = prime * result + Float.floatToIntBits(prix);
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
		Facture other = (Facture) obj;
		if (date_facture == null) {
			if (other.date_facture != null)
				return false;
		} else if (!date_facture.equals(other.date_facture))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id_facture != other.id_facture)
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facture [jardin=" + jardin + ", id_facture=" + id_facture + ", description=" + description
				+ ", date_facture=" + date_facture + ", prix=" + prix + "]";
	}

}
