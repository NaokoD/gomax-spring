package com.gomax.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gomax.entities.Majoration;

// @Repository <=> @Component <=> @Bean (Bean Spring)
@Repository
public interface MajorationRepository extends CrudRepository<Majoration, Long> {

	// queryMethods => methods to JPQL then SQL
	// SELECT c FROM contact WHERE c.name = ?1
	// SELECT * FROM contact WHERE lastname = ?1

	public Majoration findByLibelle(String libelle);
	
	// @Query => write SQL query

	//@Query("select s from Snack where s.libelle= ?1") // JPQL utilise les noms java 
	//public Snack findWithLibelle(String name);
	
	// find ()
	//SELECT * FROM T;
	
	// findById(ID param)
	//
}