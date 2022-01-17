package com.asml.petclinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asml.petclinic.model.Appointment;
import com.asml.petclinic.model.Owner;
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {



}
