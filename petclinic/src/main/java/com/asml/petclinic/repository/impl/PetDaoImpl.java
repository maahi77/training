package com.asml.petclinic.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;
import com.asml.petclinic.model.Pet;
import com.asml.petclinic.repository.AbstarctDao;

@Repository
public class PetDaoImpl extends AbstarctDao<Pet>{
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");

    /* 
     * This method returns list of
     * pets 
     * 
     * @author bindu
     * @since 2021-12-10
     * @return named query This will return list of pets
     * @exception emptyList On List is empty
     *
     */


    
    
    
	public void adding(Pet e) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(e);
        tx.commit();

	}

	public List<Pet> getAll() {
    
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Pet> namedQuery = manager.createNamedQuery("Pet.findall", Pet.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}

    /* 
     * This method returns list of
     * pets  by pet type
     * 
     * @author bindu
     *@param type is the parameter for this method

     * @since 2021-12-10
     * @return named query This will return list of pets
     * @exception emptyList On List is empty
     *
     */


	public List<Pet> findByBreed(String type) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Pet> namedQuery = manager.createNamedQuery("Pet.findbytype", Pet.class);
        namedQuery.setParameter("type",type);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());
   
		
	}

    /* 
     * This method returns list of
     * pets  by pet age
     * 
     * @author bindu
     *@param age is the parameter for this method

     * @since 2021-12-10
     * @return named query This will return list of pets
     * @exception emptyList On List is empty
     *
     */


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
