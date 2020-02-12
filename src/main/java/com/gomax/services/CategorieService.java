package com.gomax.services;


import com.gomax.entities.Categorie;
import com.gomax.repositories.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service <=> @Component <=> @Bean
@Service
public class CategorieService {

    // DI better in constructor
    // @Autowired, @Inject, @Resource
    private CategorieRepo categorieRepo;

    // Dependency Injection
    @Autowired
    public CategorieService(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }

    public List<Categorie> findAllCategories() {

        return (List<Categorie>) categorieRepo.findAll();
    }

    public Optional<Categorie> findCategorieById(Long id) {
        // use Optional
        return this.categorieRepo.findById(id);
    }

    public Categorie saveCategorie(Categorie c) {
        return this.categorieRepo.save(c);
    }

    public void deleteCategorieById(Long id) {
        this.categorieRepo.deleteById(id);
    }

    public boolean existsCategorieById(Long id) {
        return this.categorieRepo.existsById(id);
    }
}