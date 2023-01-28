package com.cm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cm.entity.EtatSubvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.EtatSubventionRepository;

@RestController
public class EtatSubventionController {

	@Autowired
	private EtatSubventionRepository etatEtatSubventionRepository;
	
	@GetMapping(value = "/etatSubvention/index")
	public List<EtatSubvention> getAllEtatSubvention() {
		return etatEtatSubventionRepository.findByOrderByIdAsc();
	}

	@GetMapping(value = "/etatSubvention/show/{id}")
	public EtatSubvention getEtatSubventionById(@PathVariable(value = "id") Long id) {
		return etatEtatSubventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EtatSubvention", "id", id));
	}

	@PostMapping(value = "/etatSubvention/new")
	public EtatSubvention createEtatSubvention(@Valid @RequestBody EtatSubvention EtatSubvention) {
		return etatEtatSubventionRepository.save(EtatSubvention);
	}

	@PutMapping(value = "/etatSubvention/edit/{id}")
	public EtatSubvention updateEtatSubvention(@PathVariable(value = "id") Long id,
			@Valid @RequestBody EtatSubvention detail) {
		EtatSubvention sub = etatEtatSubventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EtatSubvention", "id", id));
		
		sub.setEtat(detail.getEtat());
		sub.setLibelle(detail.getLibelle());
		
		return etatEtatSubventionRepository.save(sub);
	}

	@DeleteMapping(value = "/etatSubvention/delete/{id}")
	public ResponseEntity<?> deleteEtatSubvention(@PathVariable(value = "id") Long id) {
		EtatSubvention sub = etatEtatSubventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("EtatSubvention", "id", id));
		etatEtatSubventionRepository.delete(sub);
		return ResponseEntity.ok().build();
	}
}
