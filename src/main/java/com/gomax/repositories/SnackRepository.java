package com.gomax.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gomax.entities.Snack;

// @Repository <=> @Component <=> @Bean (Bean Spring)
@Repository
public interface SnackRepository extends CrudRepository<Snack, Long> {

	// queryMethods => methods to JPQL then SQL
	// SELECT c FROM contact WHERE c.name = ?1
	// SELECT * FROM contact WHERE lastname = ?1

	public Snack findByLibelle(String name);


	
	// @Query => write SQL query

	//@Query("select s from Snack where s.libelle= ?1") // JPQL utilise les noms java 
	//public Snack findWithLibelle(String name);

	
	// find ()
	//SELECT * FROM T;
	
	// findById(ID param)
	//
}