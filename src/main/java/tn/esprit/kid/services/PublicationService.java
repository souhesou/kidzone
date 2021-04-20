package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import tn.esprit.kid.entities.Publication;
import tn.esprit.kid.entities.Reaction;
import tn.esprit.kid.entities.User;
import tn.esprit.kid.enums.BadWordsEnum;
import tn.esprit.kid.enums.TypeReactionEnum;
import tn.esprit.kid.repository.PublicationRepository;
import tn.esprit.kid.repository.ReactionRepository;
import tn.esprit.kid.repository.UserRepository;


	
	@Service
	public class PublicationService implements IPublicationService {
		@Autowired
		PublicationRepository prv;
		
		@Autowired
		ReactionRepository reactionRepository;
		
		@Autowired
		UserRepository userRepository;

		@Override
		public Publication ajouterPub(Publication pub, int idUser) {
			User user = userRepository.findById(idUser).get();
			for(BadWordsEnum badWord : BadWordsEnum.values()){
				if(pub.getDescription().toLowerCase().contains(badWord.toString().toLowerCase())){
					String badString = badWord.toString().toLowerCase();
				pub.setDescription(pub.getDescription().toLowerCase().replace(badString, "********"));
				
				}
			}
			pub.setUser(user);
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

		@Override
		public void addLike(int idPost, int idUser) {
			Publication publication = prv.findById(idPost).get();
			User user = userRepository.findById(idUser).get();
			Reaction reaction = new Reaction();
			reaction.setPublication(publication);
			reaction.setUser(user);
			reaction.setTypeReaction(TypeReactionEnum.LIKE);
			reactionRepository.save(reaction);
			
		}

		@Override
		public void addDislike(int idPost, int idUser) {
			Publication publication = prv.findById(idPost).get();
			User user = userRepository.findById(idUser).get();
			Reaction reaction = new Reaction();
			reaction.setPublication(publication);
			reaction.setUser(user);
			reaction.setTypeReaction(TypeReactionEnum.DISLIKE);
			reactionRepository.save(reaction);
			
		}

		@Override
		public void removeLike(int idPost, int idUser) {
			Publication publication = prv.findById(idPost).get();
			User user = userRepository.findById(idUser).get();
			Reaction reaction = reactionRepository.findByUserAndPublication(user, publication);
			reactionRepository.delete(reaction);
			
		}

		@Override
		public void removeDislike(int idPost, int idUser) {
			Publication publication = prv.findById(idPost).get();
			User user = userRepository.findById(idUser).get();
			Reaction reaction = reactionRepository.findByUserAndPublication(user, publication);
			reactionRepository.delete(reaction);
		}
		
		
	
	}
