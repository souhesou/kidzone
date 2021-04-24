package tn.esprit.kid.services;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.RDV;
import tn.esprit.kid.repository.RDVRepository;
import tn.esprit.kid.repository.UserRepository;

@Service
public class RDVService implements IRDVService {

	@Autowired
	RDVRepository rdvRespository;

	@Autowired
	UserRepository userRepository;

	@Override
	public int ajouterRDV(RDV rdv) {
		rdvRespository.save(rdv);
		return 0;
	}

	@Override
	public void ajouterRDV2(int id_user, int id_jardin, String description, Date daterdv) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerRDV(int id_rdv) {
		rdvRespository.deleteById(id_rdv);
	}

	@Override
	public RDV modifierRDV(int id_RDV, RDV rdv) {
		RDV Rdv1 = new RDV();
		Optional<RDV> Rdv2 = this.rdvRespository.findById(id_RDV);
		if (Rdv2.isPresent()) {
			RDV FACTS = Rdv2.get();
			FACTS = rdv;
			Rdv1 = this.rdvRespository.save(FACTS);
		}
		return Rdv1;
	}

	@Override
	public List<RDV> afficherAllRDV() {
		
		//return (List<RDV>) this.rdvRespository.findAll();
		//return rdvRespository.getClass().getFields();
		
		return (List<RDV>) rdvRespository.findAll();
	}

	@Override
	public Optional<RDV> getRDVById(int idPK) {
		return this.rdvRespository.findById(idPK);
	}

	@Override
	public Optional<RDV> getAll_RDV_by_JARDIN(int id_jardin) {
		return (Optional<RDV>) this.rdvRespository.findById(id_jardin);
	}

}
