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
import com.asml.petclinic.repository.AbstarctDao;

@Repository
public class AppointmentDaoImpl extends AbstarctDao<Appointment>{
	
    public final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("local");
    
    
    /* 
     * This method returns list of
     * appointments 
     * 
     * @author mahendra
     * @since 2021-12-10
     * @return named query This will return list of appointemnts
     * @exception emptyList On List is empty
     *
     */


	public List<Appointment> getAll() {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Appointment> namedQuery = manager.createNamedQuery("Appointment.findall", Appointment.class);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}
	
	
      
    /* 
     * This method returns list of
     * appointments  by day
     * 
     * @author mahendra
     *@param day is the parameter for this method

     * @since 2021-12-10
     * @return named query This will return list of appointemnts
     * @exception emptyList On List is empty
     *
     */

	public List<Appointment> getByDay(Integer day) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        TypedQuery<Appointment> namedQuery = manager.createNamedQuery("Appointment.findbyday", Appointment.class);
        namedQuery.setParameter("day",day);
        return Optional.ofNullable(namedQuery.getResultList()).orElse(Collections.emptyList());

	}
    /* 
     * This method returns list of
     * appointments  by stimestime
     * 
     * @author mahendra
     *@param day is the parameter for this method

     * @since 2021-12-10
     * @return named query This will return list of appointemnts
     * @exception emptyList On List is empty
     *
     */


	public List<Appointment> findByStime(Integer stime) {
		
		EntityManager manager=entityManagerFactory.createEntityManager();
    	CriteriaBuilder cb=manager.getCriteriaBuilder();
    	CriteriaQuery cq=cb.createQuery();
    	Root<Appointment> appointment=cq.from(Appointment.class);
        cq.select(appointment).where(cb.between(appointment.get("stime"),10,20));
    	TypedQuery<Appointment> query=manager.createQuery(cq);
    	return Optional.ofNullable(query.getResultList()).orElse(Collections.emptyList());


	}
    /* 
     * This method add appointment 
     * details into Appointment table
     * 
     * @author mahendra
     */

	public void add(Appointment e) {
		
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(e);
        tx.commit();

	}
	


	 
}
