package com.asml.petclinic.repository;

import com.asml.training.entity.Employee;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public abstract class AbstarctDao<T> {

    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    public void add(T e){
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(e);
        tx.commit();
    }

    public void update(T e){
        EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.merge(e);
		tx.commit();
    }
	
}
