package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.repository.EvenementRepository;

@Service
public class EvenementService implements IEvenementService {
	@Autowired
	EvenementRepository iev;

	@Override
	public Evenement ajouterEvent(Evenement event) {
		return iev.save(event);
	}
<<<<<<< HEAD

=======
	
	
<<<<<<< Updated upstream
=======
>>>>>>> main
>>>>>>> Stashed changes
	@Override
	public List<Evenement> afficherEvent() {
		return (List<Evenement>) this.iev.findAll();
	}

	@Override
	public void remove(int idEvent) {
		iev.deleteById(idEvent);

	}
<<<<<<< Updated upstream
	
	
=======
<<<<<<< HEAD

=======
	
	
>>>>>>> main
>>>>>>> Stashed changes
	@Override
	public Evenement updateEvent(int idEvent, Evenement event) {
		Evenement evn = new Evenement ();
		Optional<Evenement> evn2= this.iev.findById(idEvent);
		if (evn2.isPresent()) {
			Evenement finded = evn2.get();
			finded = event;
			evn = this.iev.save(finded);
		}
		return evn;
		
	}

	@Override
	public Optional<Evenement> getById(int idEvent) {
		return this.iev.findById(idEvent);
	}

}