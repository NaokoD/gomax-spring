package com.gomax.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomax.entities.Tarif;
import com.gomax.services.TarifService;

@RestController
@RequestMapping("/tarifs")
public class TarifController {

	private TarifService tarifService;
	
	@Autowired
	TarifController(TarifService tarifService){
		this.tarifService=tarifService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tarif>> getTarifs(){
		return new ResponseEntity<List<Tarif>>(this.tarifService.findAllTarifs(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarif> getTarifById(@PathVariable Long id){
		return new ResponseEntity<Tarif>(this.tarifService.findTarifById(id).get(), HttpStatus.OK);
	}
}
