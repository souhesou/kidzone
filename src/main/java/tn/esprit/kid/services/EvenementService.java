package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Enfant;
import tn.esprit.kid.entities.Evenement;
import tn.esprit.kid.repository.EvenementRepository;

@Service
public class EvenementService implements IEvenementService {
	@Autowired
	EvenementRepository iev;
	
	@Override
	public Evenement ajouterEvent(Evenement event) {
		return iev.save(event) ;
	}
	
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Evenement> getById(int idEvent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}