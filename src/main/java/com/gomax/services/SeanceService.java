package com.gomax.services;


import com.gomax.entities.Film;
import com.gomax.entities.Seance;
import com.gomax.repositories.SeanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// @Service <=> @Component <=> @Bean
@Service
public class SeanceService {

    // DI better in constructor
    // @Autowired, @Inject, @Resource
    private SeanceRepo seanceRepo;

    // Dependency Injection
    @Autowired
    public SeanceService(SeanceRepo seanceRepo) {
        this.seanceRepo = seanceRepo;
    }

    public List<Seance> findAllSeances() {

        return (List<Seance>) seanceRepo.findAll();
    }


    public Optional<Seance> findSeanceById(Long id) {
        // use Optional
        return this.seanceRepo.findById(id);
    }


    public List<Seance> findAllSeancesByFilmId(Long idFilm){
        Film film = new Film();
        film.setId(idFilm);
        return (List<Seance>) seanceRepo.findByFilm(film);
    }


    public Seance saveSeance(Seance s) {
        return this.seanceRepo.save(s);
    }

    public void deleteSeanceById(Long id) {
        this.seanceRepo.deleteById(id);
    }

    public boolean existsSeanceById(Long id) {
        return this.seanceRepo.existsById(id);
    }

    public Integer findNombreDePlaceBySeance(Long id){
        return this.seanceRepo.findNombreDePlacesPrises(id);
    }

    public Integer findNombreDePlacesRestantesBySeanceById(Long id){
        int nbPlacesDansLaSalle = this.findSeanceById(id).get().getSalle().getNombreDePlace();
        if( this.findNombreDePlaceBySeance(id) != null){
            return nbPlacesDansLaSalle - this.findNombreDePlaceBySeance(id);
        }else
            return nbPlacesDansLaSalle;
    }

    public List<Seance> findSeanceOnMonday(Long id){
        return  seanceRepo.findSeanceOnMondayByFilm(id);
    }

    public List<Seance> findSeanceOnTuesday(Long id){
        return  seanceRepo.findSeanceOnTuesdayByFilm(id);
    }

    public List<Seance> findSeanceOnWednesday(Long id){
        return  seanceRepo.findSeanceOnWednesdayByFilm(id);
    }

    public List<Seance> findSeanceOnThursday(Long id){
        return  seanceRepo.findSeanceOnThursdayByFilm(id);
    }

    public List<Seance> findSeanceOnFriday(Long id){
        return  seanceRepo.findSeanceOnFridayByFilm(id);
    }

    public List<Seance> findSeanceOnSaturday(Long id){
        return  seanceRepo.findSeanceOnSaturdayByFilm(id);
    }

    public List<Seance> findSeanceOnSunday(Long id){
        return  seanceRepo.findSeanceOnSundayByFilm(id);
    }


}