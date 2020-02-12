package com.gomax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomax.entities.Cinema;
import com.gomax.repositories.CinemaRepository;

@Service
public class CinemaService {

	private CinemaRepository cinemaRepository;
	
	@Autowired
	CinemaService(CinemaRepository cinemaRepository){
		this.cinemaRepository = cinemaRepository;
	}
	
	public List<Cinema> findAllCinema(){
		return (List<Cinema>) this.cinemaRepository.findAll();
	}
	
	public Optional<Cinema> findCinemaById(Long id) {
		return this.cinemaRepository.findById(id);
	}
	
	public Cinema saveCinema(Cinema cinema) {
		return this.cinemaRepository.save(cinema);
	}
	
	public void deleteCinema(Cinema cinema) {
		this.cinemaRepository.delete(cinema);
	}
}
