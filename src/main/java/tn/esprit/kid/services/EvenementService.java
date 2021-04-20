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
	//service.sendSimpleEmail("souha.saada@esprit.tn", "ur child event is starting now", "event");
	return iev.save(event);}
	
	@Override
	public List<Evenement> afficherEvent() {
		return (List<Evenement>) this.iev.findAll();
	}

	@Override
	public void remove(int idEvent) {
		iev.deleteById(idEvent);

	}
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

	@Override
	public List<Evenement> FindEventByName() {
		return iev.FindEventByName();
	}

	
	@Override
	public List<Evenement> Search(String word) {
		return (List<Evenement>) iev.searchEvent(word);
	}
	
	
	
}