package com.gomax.repositories;

import com.gomax.entities.Salle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleRepository extends CrudRepository<Salle, Long> {
}
