package com.gomax.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gomax.entities.Majoration;
import com.gomax.repositories.MajorationRepository;

// @Service <=> @Component <=> @Bean
@Service
public class MajorationService {
	
	//DI (Injection de Dépendence) better in constructeur
	// @Autowired, @Inject, @Resource
	
	private MajorationRepository majorationRepo;
	
	// Dependency Injection (DI)
	@Autowired
	public MajorationService(MajorationRepository mr) {
		this.majorationRepo = mr;
	}
	
	public List<Majoration> findAllMajorations() {
		// (CAST) Iterable <Contact>
		return (List<Majoration>) majorationRepo.findAll();
	}
	
	//public Optional<Contact> findContactById(Long id) {
        // use Optional
        //return this.contactRepo.findById(id);
    //}

	public Majoration findMajorationById(Long id) {
		return this.majorationRepo.findById(id).get();
	}
	
	public Majoration saveMajoration(Majoration m) {
		return this.majorationRepo.save(m);
		
	}
	
	public void deleteMajorationById(Long id) {
		this.majorationRepo.deleteById(id);
		
	}
	
	public boolean existsMajorationById(Long id) {
		return this.majorationRepo.existsById(id);
		
	}
	
}
