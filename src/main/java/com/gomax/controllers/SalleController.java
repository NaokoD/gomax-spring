package com.gomax.controllers;

import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gomax.entities.Salle;
import com.gomax.services.SalleService;

@RestController
@RequestMapping("/salles")
@CrossOrigin(origins = "http://localhost:4200")
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

    @PostMapping("")
    public ResponseEntity<Salle> postSalle(@RequestBody Salle salle){
        return new ResponseEntity<>(this.salleService.saveSalle(salle), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSalleById(@PathVariable Long id){
        return new ResponseEntity<>(this.salleService.deleteSalleById(id), HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Salle> putSalle(@RequestBody Salle salle){
        return new ResponseEntity<>(this.salleService.saveSalle(salle), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}/plan", produces = "application/json" )
    public String getPlan(@PathVariable("id") Salle salle) {
        return this.PlanSalleFromXmlToJSon(salle);
    }



    public  String PlanSalleFromXmlToJSon(Salle salle){
        String planXML = salle.getPlan();
        //System.out.println(planXML);
        JSONObject jsonObject = XML.toJSONObject(planXML);
        String planJson = jsonObject.toString();
        //System.out.println(planJson);
        return planJson;
    }
    
}
