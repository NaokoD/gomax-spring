package com.gomax.repositories;

import com.gomax.entities.Commande;
import com.gomax.entities.Seance;
import com.gomax.entities.Siege;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Repository
public interface SiegeRepository extends CrudRepository<Siege, Long> {

    Set<Siege> findByCommandes(Commande commande);

    @Query(value ="SELECT siege_id as id FROM commande c JOIN commande_siege cs ON c.id = cs.commande_id WHERE seance_id = :seanceId ORDER BY id", nativeQuery = true)
    Set<Siege> findBySeance(@Param("seanceId") Long seanceId);
//
//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")

    @Query(value ="SELECT c.sieges as id FROM Commande c")
    Set<Siege> findSiegesInCommande();
}
