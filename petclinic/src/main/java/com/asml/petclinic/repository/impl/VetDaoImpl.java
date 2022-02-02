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

import com.asml.petclinic.model.Pet;
import com.asml.petclinic.model.Vet;
import com.asml.petclinic.repository.AbstarctDao;

@Repository
public class VetDaoImpl extends AbstarctDao<Vet> {
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");


    
    /* 
     * This method returns list of
     * vets 
     * 
     * @author bindu
     * @since 2021-12-10
     * @return named query This will return list of pets
     * @exception emptyList On List is empty
     *
     */

	public List<Vet> getAll() {
    
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Vet> namedQuery = manager.createNamedQuery("Vet.findall", Vet.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}

    /* 
     * This method returns list of
     * vets  by vet name
     * 
     * @author bindu
     *@param name is the parameter for this method

     * @since 2021-12-10
     * @return named query This will return list of pets
     * @exception emptyList On List is empty
     *
     */


	public List<Vet> findByVetName(String name) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Vet> namedQuery = manager.createNamedQuery("Vet.findbyvetname", Vet.class);
        namedQuery.setParameter("name",name);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());
		
	}

    /* 
     * This method returns list of
     * vets  by vet name
     * 
     * @author bindu
     *@param name is the parameter for this method

     * @since 2021-12-10
     * @return named query This will return list of pets
     * @exception emptyList On List is empty
     *
     */


	public List<Vet> findByVetNameLike(String name) {
		
		EntityManager manager=entityManagerFactory.createEntityManager();
    	CriteriaBuilder cb=manager.getCriteriaBuilder();
    	CriteriaQuery cq=cb.createQuery();
    	Root<Vet> root=cq.from(Vet.class);
        cq.select(root).where(cb.like(root.get("name"),"%he%"));
    	TypedQuery<Vet> query=manager.createQuery(cq);
    	return Optional.ofNullable(query.getResultList()).orElse(Collections.emptyList());

	}
	
	public void add(Vet e) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(e);
        tx.commit();

	}

}
