package com.gomax.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomax.entities.Snack;
import com.gomax.repositories.SnackRepository;

@Service
public class SnackService {
	
	private SnackRepository snackRepo;
	
	@Autowired
	public SnackService(SnackRepository sr) {
		this.snackRepo = sr;
	}
	
	public List<Snack> findAllSnacks() {
		return (List<Snack>) snackRepo.findAll();
	}

	public Snack findSnackById(Long id) {
		return this.snackRepo.findById(id).get();
	}
	
	public Snack saveSnack(Snack s) {
		return this.snackRepo.save(s);	
	}
	
	public List<Snack> saveSnackAll(List<Snack> s) {
		return (List<Snack>) this.snackRepo.saveAll(s);	
	}
	
	public void deleteSnackById(Long id) {
		this.snackRepo.deleteById(id);
	}
	
	public boolean existsSnackById(Long id) {
		return this.snackRepo.existsById(id);
	}
}
