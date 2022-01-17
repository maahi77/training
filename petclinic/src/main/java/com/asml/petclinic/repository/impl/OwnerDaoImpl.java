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

@Repository
public class OwnerDaoImpl {

    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    


	public List<Owner> getAll() {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Owner> namedQuery = manager.createNamedQuery("Owner.findall", Owner.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}

	public List<Owner> getByName(String owner_name) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Owner> namedQuery = manager.createNamedQuery("Owner.finbyname", Owner.class);
        namedQuery.setParameter("owner_name",owner_name);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}

	public List<Owner> getByNameAndNum(String owner_name, Integer num) {
               
		EntityManager manager=entityManagerFactory.createEntityManager();
    	CriteriaBuilder cb=manager.getCriteriaBuilder();
    	CriteriaQuery cq=cb.createQuery();
    	Root<Owner> owner=cq.from(Owner.class);
    	javax.persistence.criteria.Predicate namePredicate=cb.equal(owner.get("owner_name"),owner_name);
    	javax.persistence.criteria.Predicate numPredicate=cb.equal(owner.get("num"),num);
    	cq.where(namePredicate,numPredicate);
    	cq.select(owner);
    	TypedQuery<Owner> query=manager.createQuery(cq);
    	cq.select(owner);
    	return Optional.ofNullable(query.getResultList()).orElse(Collections.emptyList());
		
	}

}
