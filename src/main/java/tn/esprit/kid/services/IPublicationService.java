package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.kid.entities.Publication;

public interface IPublicationService {

	public Publication ajouterPub(Publication pub, int idUser);

	public List<Publication> afficherPub();

	public void remove(int idPub);

	public Publication updatePub(int idPub, Publication pub);

	Optional<Publication> getById(int idPub);

	public void addLike(int idPost, int idUser);

	public void addDislike(int idPost, int idUser);

	public void removeLike(int idPost, int idUser);

	public void removeDislike(int idPost, int idUser);



}