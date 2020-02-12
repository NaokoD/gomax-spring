package com.gomax.repositories;

import com.gomax.entities.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepo extends CrudRepository<Categorie, Long> {

    public  Categorie findByLibelle(String libelle);

    @Query(value = "SELECT * FROM Categorie WHERE libelle LIKE %?1%", nativeQuery = true)
    public Categorie findWithLibelle(String libelle);
}
