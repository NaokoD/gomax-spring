package com.gomax.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomax.services.MajorationService;

import com.gomax.entities.Majoration;

// @RestController <=> @Component <=> @Bean
@RestController
@RequestMapping("/majorations")
public class MajorationController {
	
	private MajorationService majorationService;
	
	@Autowired
	public MajorationController(MajorationService ms) {
		this.majorationService = ms;
	}

	
	@GetMapping("")
	public ResponseEntity<List<Majoration>> getMajoration() {
		return new ResponseEntity<>(this.majorationService.findAllMajorations(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Majoration> getMajorationById(@PathVariable Long id) {	
		return new ResponseEntity<>(this.majorationService.findMajorationById(id), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Majoration> postMajoration(@RequestBody Majoration m) {
		return new ResponseEntity<Majoration>(this.majorationService.saveMajoration(m), HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<Majoration> putMajoration(@RequestBody Majoration m) {	
		
		// if we don't want to allow creation on PUT
        // we need to check if contact exist before update (to avoid creation)
        if(this.majorationService.existsMajorationById(m.getId()))
            return new ResponseEntity<>(this.majorationService.saveMajoration(m), HttpStatus.OK);
        else
            return new ResponseEntity<>(m, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> deleteMajorationById(@PathVariable Long id) {	
		this.majorationService.deleteMajorationById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
