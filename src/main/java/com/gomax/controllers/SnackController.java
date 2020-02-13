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

import com.gomax.services.SnackService;
import com.gomax.entities.Snack;

@RestController
@RequestMapping("/snack")
public class SnackController {
	
	private SnackService snackService;
	
	@Autowired
	public SnackController(SnackService sn) {
		this.snackService = sn;
	}

	@GetMapping("")
	public ResponseEntity<List<Snack>> getSnacks() {
		return new ResponseEntity<>(this.snackService.findAllSnacks(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Snack> getSnackById(@PathVariable Long id) {	
		return new ResponseEntity<>(this.snackService.findSnackById(id), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Snack> postSnack(@RequestBody Snack s) {
		return new ResponseEntity<Snack>(this.snackService.saveSnack(s), HttpStatus.CREATED);
	}
	
	@PutMapping("")
	public ResponseEntity<Snack> putSnack(@RequestBody Snack s) {	
		
        if(this.snackService.existsSnackById(s.getId()))
            return new ResponseEntity<>(this.snackService.saveSnack(s), HttpStatus.OK);
        else
            return new ResponseEntity<>(s, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> deleteSnackById(@PathVariable Long id) {	
		this.snackService.deleteSnackById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
