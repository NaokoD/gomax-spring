package com.gomax.controllers;

import com.gomax.entities.Horaire;
import com.gomax.services.HoraireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horaires")
public class HoraireController {

    private HoraireService horaireService;

    @Autowired
    public HoraireController(HoraireService horaireService) {
      this.horaireService = horaireService;
    }


    @GetMapping("")
    public ResponseEntity<List<Horaire>> getHoraires() {
        return new ResponseEntity<>(this.horaireService.findAllHoraires(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horaire> getHoraireById(@PathVariable Long id) {
        return new ResponseEntity<>(this.horaireService.findHoraireById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Horaire> postHoraire(@RequestBody Horaire h) {
        return new ResponseEntity<>(this.horaireService.saveHoraire(h),
                HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Horaire> putHoraire(@RequestBody Horaire h) {
        if (this.horaireService.existsHoraireById(h.getId()))
            return new ResponseEntity<>(this.horaireService.saveHoraire(h),
                    HttpStatus.OK);
        else
            return new ResponseEntity<>(h,
                    HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoraireById(@PathVariable Long id) {
        this.horaireService.deleteHoraireById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}