package com.gomax.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomax.entities.Tarif;
import com.gomax.repositories.TarifRepository;

@Service
public class TarifService {
	
	private TarifRepository tarifRepository;
	
	@Autowired
	TarifService(TarifRepository tarifRepository){
		this.tarifRepository= tarifRepository;
	}
	
	public List<Tarif> findAllTarifs(){
		return (List<Tarif>) this.tarifRepository.findAll();
	}
	
	public Optional<Tarif> findTarifById(Long id) {
		return this.tarifRepository.findById(id);
	}
	
	public Tarif saveTarif(Tarif tarif) {
		return this.tarifRepository.save(tarif);
	}
	
	public Boolean deleteTarifById(Long id) {
		this.tarifRepository.deleteById(id);
		return this.tarifRepository.existsById(id);
	}
}
