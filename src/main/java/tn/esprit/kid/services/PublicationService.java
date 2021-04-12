package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.kid.entities.Publication;
import tn.esprit.kid.repository.PublicationRepository;


	
	@Service
	public class PublicationService implements IPublicationService {
		@Autowired
		PublicationRepository prv;

		@Override
		public Publication ajouterPub(Publication pub) {
			return prv.save(pub) ;
		}

		@Override
		public List<Publication> afficherPub() {
			return (List<Publication>) this.prv.findAll();
			
		}

		@Override
		public void remove(int idPub) {
			prv.deleteById(idPub);
			
		}

		@Override
		public Publication updatePub(int idPub, Publication pub) {
			Optional<Publication> pub2= this.prv.findById(idPub);
			if (pub2.isPresent()) {
				Publication finded = pub2.get();
				finded = pub;
				pub = this.prv.save(finded);
			}
			return pub;
			
		}

		@Override
		public Optional<Publication> getById(int idPub) {
			// TODO Auto-generated method stub
			return this.prv.findById(idPub);
		}
		
		
	
	}
