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

import com.cm.entity.Impression;
import com.cm.entity.TypeImpression;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.ImpressionRepository;
import com.cm.repository.TypeImpressionRepository;

@RestController
public class TypeImpressionController {

	@Autowired
	private TypeImpressionRepository typeImpressionRepository;
	
	@Autowired
	private ImpressionRepository impressionRepository;
	
	@GetMapping(value = "/typeImpression/index")
	public List<TypeImpression> getAllTypeImpression() {
		return typeImpressionRepository.findAll();
	}
	
	@GetMapping(value = "/typeImpression/impression/{id}")
	public List<TypeImpression> getAllTypeImpressionByImpression(@PathVariable(value = "id") Long id) {
		Impression resto = impressionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Impression", "id", id));
		return typeImpressionRepository.findByImpressionOrderByIdDesc(resto);
	}

	@GetMapping(value = "/typeImpression/show/{id}")
	public TypeImpression getTypeImpressionById(@PathVariable(value = "id") Long typeId) {
		return typeImpressionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeImpression", "typeId", typeId));
	}

	@PostMapping(value = "/typeImpression/new")
	public TypeImpression createTypeImpression(@Valid @RequestBody TypeImpression TypeImpression) {
		return typeImpressionRepository.save(TypeImpression);
	}

	@PutMapping(value = "/typeImpression/edit/{id}")
	public TypeImpression updateTypeImpression(@PathVariable(value = "id") Long typeId,
			@Valid @RequestBody TypeImpression detail) {
		TypeImpression TypeImpression = typeImpressionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeImpression", "typeId", typeId));

		TypeImpression.setDesignation(detail.getDesignation());
		TypeImpression.setPrixUnitaire(detail.getPrixUnitaire());
		TypeImpression.setQuantite(detail.getQuantite());
		TypeImpression.setImpression(detail.getImpression());
		TypeImpression.setTotalHT(detail.getTotalHT());
		TypeImpression.setTotalTTC(detail.getTotalTTC());
		return typeImpressionRepository.save(TypeImpression);
	}

	@DeleteMapping(value = "/typeImpression/delete/{id}")
	public ResponseEntity<?> deleteTypeImpression(@PathVariable(value = "id") Long typeId) {
		TypeImpression TypeImpression = typeImpressionRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeImpression", "typeId", typeId));
		typeImpressionRepository.delete(TypeImpression);
		return ResponseEntity.ok().build();
	}
}
