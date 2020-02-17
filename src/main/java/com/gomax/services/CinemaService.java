package com.gomax.services;

import com.gomax.entities.Cinema;
import com.gomax.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    private CinemaRepository cinemaRepository;

    @Autowired
    CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public List<Cinema> findAllCinemas() {
        return (List<Cinema>) this.cinemaRepository.findAll();
    }

    public Optional<Cinema> findCinemaById(Long id) {
        return this.cinemaRepository.findById(id);
    }

    public Cinema saveCinema(Cinema cinema) {
        return this.cinemaRepository.save(cinema);
    }

    public Boolean deleteCinemaById(Long id) {
        this.cinemaRepository.deleteById(id);
        return this.cinemaRepository.existsById(id);
    }
}
