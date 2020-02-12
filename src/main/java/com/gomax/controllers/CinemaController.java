package com.gomax.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomax.entities.Cinema;
import com.gomax.services.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

	private CinemaService cinemaService;
	
	@Autowired
	CinemaController(CinemaService cinemaService){
		this.cinemaService = cinemaService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Cinema>> getAllCinema(){
		return new ResponseEntity<List<Cinema>>(this.cinemaService.findAllCinema(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cinema> getCinemaById(@PathVariable Long id){
		return new ResponseEntity<Cinema>(this.cinemaService.findCinemaById(id).get(), HttpStatus.OK);
	}
}
