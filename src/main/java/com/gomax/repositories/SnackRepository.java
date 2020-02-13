package com.gomax.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gomax.entities.Snack;

@Repository
public interface SnackRepository extends CrudRepository<Snack, Long> {

	public Snack findByLibelle(String name);

}