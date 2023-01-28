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

import com.cm.entity.SousTypeSubvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.SousTypeSubventionRepository;

@RestController
public class SousTypeSubventionController {

	@Autowired
	private SousTypeSubventionRepository sousTypeSubventionRepository;
	
	@GetMapping(value = "/sousTypeSubvention/index")
	public List<SousTypeSubvention> getAllSubvention() {
		return sousTypeSubventionRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/sousTypeSubvention/show/{id}")
	public SousTypeSubvention getSubventionById(@PathVariable(value = "id") Long id) {
		return sousTypeSubventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SousTypeSubvention", "id", id));
	}

	@PostMapping(value = "/sousTypeSubvention/new")
	public SousTypeSubvention createSubvention(@Valid @RequestBody SousTypeSubvention Subvention) {
		return sousTypeSubventionRepository.save(Subvention);
	}

	@PutMapping(value = "/sousTypeSubvention/edit/{id}")
	public SousTypeSubvention updateSubvention(@PathVariable(value = "id") Long id,
			@Valid @RequestBody SousTypeSubvention detail) {
		SousTypeSubvention sub = sousTypeSubventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SousTypeSubvention", "id", id));
		
		sub.setLibelle(detail.getLibelle());
		return sousTypeSubventionRepository.save(sub);
	}

	@DeleteMapping(value = "/sousTypeSubvention/delete/{id}")
	public ResponseEntity<?> deleteSubvention(@PathVariable(value = "id") Long id) {
		SousTypeSubvention sub = sousTypeSubventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("SousTypeSubvention", "id", id));
		sousTypeSubventionRepository.delete(sub);
		return ResponseEntity.ok().build();
	}
}
