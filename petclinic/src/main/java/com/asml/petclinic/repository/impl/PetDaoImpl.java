package com.asml.petclinic.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;
import com.asml.petclinic.model.Pet;

@Repository
public class PetDaoImpl {
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");


	public List<Pet> getAll() {
    
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Pet> namedQuery = manager.createNamedQuery("Pet.findall", Pet.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}


	public List<Pet> findByBreed(String type) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Pet> namedQuery = manager.createNamedQuery("Pet.finbytype", Pet.class);
        namedQuery.setParameter("type",type);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());
   
		
	}


	public List<Pet> findByAges(Integer age) {
		
		EntityManager manager=entityManagerFactory.createEntityManager();
    	CriteriaBuilder cb=manager.getCriteriaBuilder();
    	CriteriaQuery cq=cb.createQuery();
    	Root<Pet> ages=cq.from(Pet.class);
        cq.select(ages).where(cb.between(ages.get("age"),10,20));
    	TypedQuery<Pet> query=manager.createQuery(cq);
    	return Optional.ofNullable(query.getResultList()).orElse(Collections.emptyList());

		
	}
	
	
	

}
