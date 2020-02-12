package com.gomax.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gomax.entities.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long>{

}
