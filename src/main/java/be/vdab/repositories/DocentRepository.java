package be.vdab.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Docent;
import be.vdab.filters.JPAFilter;

// enkele imports ...
public class DocentRepository {
	
	
public Optional<Docent> read(long id, EntityManager eman) {
EntityManager entityManager = eman; 

return Optional.ofNullable(entityManager.find(Docent.class, id)); 

}

public void create(Docent docent, EntityManager em) {
	
	em.persist(docent);
	
}

public void delete(long id, EntityManager entityManager) {
read(id,entityManager) 
.ifPresent(docent -> entityManager.remove(docent)); 
}


}