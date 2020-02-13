package com.gomax.controllers;

import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomax.entities.Salle;
import com.gomax.services.SalleService;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private SalleService salleService;

    @Autowired
    public SalleController(SalleService salleService){
        this.salleService = salleService;
    }

    @GetMapping("")
    public ResponseEntity<List<Salle>> getAllSalle(){
        return new ResponseEntity<>(this.salleService.findAllSalles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getSalleById(@PathVariable Long id){
        return new ResponseEntity<>(this.salleService.findSalleById(id).get(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}/plan", produces = "application/json" )
    String getPlan(@PathVariable("id") Salle salle) {
    	String planXML = salle.getPlan();

    	JSONObject jsonObject = XML.toJSONObject(planXML);
    	String planJson = jsonObject.toString();
    	return planJson;
    }
    
}
