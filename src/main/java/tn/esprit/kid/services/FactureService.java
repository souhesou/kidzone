package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Facture;
import tn.esprit.kid.repository.FactureRepository;
import tn.esprit.kid.repository.RDVRepository;
import tn.esprit.kid.repository.UserRepository;

@Service
public class FactureService implements IFactureService {

	@Autowired
	FactureRepository factureRepository;
	@Autowired
	RDVRepository rdvRespository;

	@Autowired
	UserRepository userRepository;

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
	public Facture modifierFacture(int id_facture, Facture fact) {
		Facture facture = new Facture();
		Optional<Facture> fact2 = this.factureRepository.findById(id_facture);
		if (fact2.isPresent()) {
			Facture FACTS = fact2.get();
			FACTS = fact;
			facture = this.factureRepository.save(FACTS);
		}
		return facture;
	}

	public List<Facture> afficherAllFacture() {

		return (List<Facture>) this.factureRepository.findAll();
	}

	public Optional<Facture> getAllFactureIDByJardin(int id_jardin) {
		/* return (List<Facture>) this.factureRepository.findById(id_jardin); */

		return (Optional<Facture>) this.factureRepository.findById(id_jardin);

	}

	@Override
	public Optional<Facture> getFactureById(int id_facture) {
		// TODO Auto-generated method stub
		return this.factureRepository.findById(id_facture);
	}

}
