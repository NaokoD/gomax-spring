package com.gomax.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gomax.entities.Tarif;
import com.gomax.services.TarifService;

@RestController
@RequestMapping("/tarifs")
@CrossOrigin(origins = "http://localhost:4200")
public class TarifController {

	private TarifService tarifService;
	
	@Autowired
	TarifController(TarifService tarifService){
		this.tarifService=tarifService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tarif>> getTarifs(){
		return new ResponseEntity<>(this.tarifService.findAllTarifs(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarif> getTarifById(@PathVariable Long id){
		return new ResponseEntity<>(this.tarifService.findTarifById(id).get(), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Tarif> postTarif(@RequestBody Tarif tarif){
		return new ResponseEntity<>(this.tarifService.saveTarif(tarif), HttpStatus.CREATED);
	}

	@PutMapping("")
	public ResponseEntity<Tarif> putTarif(@RequestBody Tarif tarif){
		return new ResponseEntity<>(this.tarifService.saveTarif(tarif), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTarif(@PathVariable Long id){
		return new ResponseEntity<>(this.tarifService.deleteTarifById(id), HttpStatus.OK);
	}
}
