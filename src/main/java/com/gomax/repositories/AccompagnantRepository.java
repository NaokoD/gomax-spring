package com.gomax.repositories;

import com.gomax.entities.Accompagnant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccompagnantRepository extends CrudRepository<Accompagnant, Long> {
}
