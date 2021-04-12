package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Facture;
import tn.esprit.kid.repository.FactureRepository;

@Service
public class FactureService implements IFactureService {

	@Autowired
	FactureRepository factureRepository;

	@Override
	public int ajouterFacture(Facture facture) {
		factureRepository.save(facture);
		return facture.getId_facture();
	}

	@Override
	public void supprimerFacture(int id_facture) {
		factureRepository.deleteById(id_facture);

	}

	@Override
	public Facture modifierFacture(int id_facture, Facture facture) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Facture> afficherAllFacture() {

		return (List<Facture>) this.factureRepository.findAll();
	}

	public List<String> getAllFactureIDByJardin(int id_jardin) {
		return null;

	}

	@Override
	public Optional<Facture> getFactureById(int id_facture) {
		// TODO Auto-generated method stub
		return this.factureRepository.findById(id_facture);
	}

}
