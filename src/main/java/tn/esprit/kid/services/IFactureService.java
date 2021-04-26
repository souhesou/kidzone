package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.Facture;

public interface IFactureService {

	public int ajouterFacture(Facture facture);

	public void supprimerFacture(int id_facture);

	public Facture modifierFacture(int id_facture, Facture facture);

	public List<Facture> afficherAllFacture();

	public Optional<Facture> getAllFactureIDByJardin(int id_jardin);

	Optional<Facture> getFactureById(int id_facture);

}
