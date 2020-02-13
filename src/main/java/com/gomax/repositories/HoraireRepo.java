package com.gomax.repositories;

import com.gomax.entities.Horaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface HoraireRepo extends CrudRepository<Horaire, Long> {

}