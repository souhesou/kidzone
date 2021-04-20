package tn.esprit.kid.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.kid.entities.Jardin;
import tn.esprit.kid.repository.JardinRepository;

@Service
public class JardinService implements IJardinService{
	@Autowired
	JardinRepository ij;
	@Override
	public Jardin ajouterJardin(Jardin jardin) {
		
		return ij.save(jardin);
	}
	@Override
	public List<Jardin> afficherJardin() {
		// TODO Auto-generated method stub
		return (List<Jardin>) this.ij.findAll();
	}
	
	@Override
	public void supprimer(int id) {
		ij.deleteById(id);
		
	}
	@Override
	public Jardin updateJardin(int id, Jardin jardin) {
		Jardin jar = new Jardin();
		Optional<Jardin> jar2 = this.ij.findById(id);
		if(jar2.isPresent()){
			
			Jardin finded = jar2.get();
			finded = jardin;
			jar = this.ij.save(finded);
		}
		return jar;
	}

	@Override
	public Optional<Jardin> getById(int id) {
		
		return this.ij.findById(id);
	}



	


	

}
