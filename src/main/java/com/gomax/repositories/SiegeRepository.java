package com.gomax.repositories;

import com.gomax.entities.Commande;
import com.gomax.entities.Siege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Repository
public interface SiegeRepository extends CrudRepository<Siege, Long> {

    public List<Siege> findByCommandes(Commande commande);
}
