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

import com.cm.entity.Restauration;
import com.cm.entity.TypePlat;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.RestaurationRepository;
import com.cm.repository.TypePlatRepository;

@RestController
public class TypePlatController {

	@Autowired
	private TypePlatRepository TypePlatRepository;
	
	@Autowired
	private RestaurationRepository restoRepo;
	
	@GetMapping(value = "/typePlat/index")
	public List<TypePlat> getAllTypePlat() {
		return TypePlatRepository.findAll();
	}
	
	@GetMapping(value = "/typePlat/restauration/{id}")
	public List<TypePlat> getAllTypePlatByRestauration(@PathVariable(value = "id") Long id) {
		Restauration resto = restoRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restauration", "id", id));
		return TypePlatRepository.findByRestaurationOrderByIdDesc(resto);
	}

	@GetMapping(value = "/typePlat/show/{id}")
	public TypePlat getTypePlatById(@PathVariable(value = "id") Long typeId) {
		return TypePlatRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypePlat", "typeId", typeId));
	}

	@PostMapping(value = "/typePlat/new")
	public TypePlat createTypePlat(@Valid @RequestBody TypePlat typePlat) {
		return TypePlatRepository.save(typePlat);
	}

	@PutMapping(value = "/typePlat/edit/{id}")
	public TypePlat updateTypePlat(@PathVariable(value = "id") Long typeId,
			@Valid @RequestBody TypePlat detail) {
		TypePlat typePlat = TypePlatRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypePlat", "typeId", typeId));

		typePlat.setDesignation(detail.getDesignation());
		typePlat.setPrixUnitaire(detail.getPrixUnitaire());
		typePlat.setQuantite(detail.getQuantite());
		typePlat.setRestauration(detail.getRestauration());
		typePlat.setTotalHT(detail.getTotalHT());
		typePlat.setTotalTTC(detail.getTotalTTC());
		return TypePlatRepository.save(typePlat);
	}

	@DeleteMapping(value = "/typePlat/delete/{id}")
	public ResponseEntity<?> deleteTypePlat(@PathVariable(value = "id") Long typeId) {
		TypePlat typePlat = TypePlatRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypePlat", "typeId", typeId));
		TypePlatRepository.delete(typePlat);
		return ResponseEntity.ok().build();
	}
}
