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
	public Snack findByLibelle(String libelle);
	
	// @Query => write SQL query
	@Query(value = "SELECT * FROM snack WHERE libelle LIKE %?1%", nativeQuery = true)
	public Snack findWithLibelle(String libelle);
	
	// find ()
	//SELECT * FROM T;
	
	// findById(ID param)
	//
}