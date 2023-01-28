package com.cm.controller;

import java.util.List;
import java.util.Set;

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
import com.cm.entity.TypeSubvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.TypeSubventionRepository;

@RestController
public class TypeSubventionController {

	@Autowired
	private TypeSubventionRepository TypeSubventionRepository;
	
	@GetMapping(value = "/typeSubvention/index")
	public List<TypeSubvention> getAllTypeSubvention() {
		return TypeSubventionRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/typeSubvention/show/{id}")
	public TypeSubvention getTypeSubventionById(@PathVariable(value = "id") Long typeId) {
		return TypeSubventionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeSubvention", "typeId", typeId));
	}
	
	@GetMapping(value = "/typeSubvention/sousType/{id}")
	public Set<SousTypeSubvention> getSousTypeByType(@PathVariable(value = "id") Long typeId)
			throws ResourceNotFoundException {
		TypeSubvention type = TypeSubventionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("typeImmobilisation", "typeId", typeId));
		Set<SousTypeSubvention> sousTypes = type.getSousTypeSubventions();
		return sousTypes;
	}

	@PostMapping(value = "/typeSubvention/new")
	public TypeSubvention createTypeSubvention(@Valid @RequestBody TypeSubvention typeImmo) {
		return TypeSubventionRepository.save(typeImmo);
	}

	@PutMapping(value = "/typeSubvention/edit/{id}")
	public TypeSubvention updateTypeSubvention(@PathVariable(value = "id") Long typeId,
			@Valid @RequestBody TypeSubvention details) {
		TypeSubvention sub = TypeSubventionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeSubvention", "typeId", typeId));

		sub.setLibelle(details.getLibelle());
		return TypeSubventionRepository.save(sub);
	}

	@DeleteMapping(value = "/typeSubvention/delete/{id}")
	public ResponseEntity<?> deleteTypeSubvention(@PathVariable(value = "id") Long typeId) {
		TypeSubvention sub = TypeSubventionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeSubvention", "typeId", typeId));
		TypeSubventionRepository.delete(sub);
		return ResponseEntity.ok().build();
	}
}
