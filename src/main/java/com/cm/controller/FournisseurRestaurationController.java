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

import com.cm.entity.FournisseurRestauration;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.FournisseurRestaurationRepository;

@RestController
public class FournisseurRestaurationController {

	@Autowired
	private FournisseurRestaurationRepository fournisseurRestaurationRepository;

	@GetMapping(value = "/fournisseurRestauration/index")
	public List<FournisseurRestauration> getAllFournisseurRestauration() {
		return fournisseurRestaurationRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/fournisseurRestauration/show/{id}")
	public FournisseurRestauration getFournisseurRestaurationById(@PathVariable(value = "id") Long id) {
		return fournisseurRestaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FournisseurRestauration", "id", id));
	}

	@PostMapping(value = "/fournisseurRestauration/new")
	public FournisseurRestauration createFournisseurRestauration(
			@Valid @RequestBody FournisseurRestauration fournisseurRestauration) {
		return fournisseurRestaurationRepository.save(fournisseurRestauration);
	}

	@PutMapping(value = "/fournisseurRestauration/edit/{id}")
	public FournisseurRestauration updateFournisseurRestauration(@PathVariable(value = "id") Long id,
			@Valid @RequestBody FournisseurRestauration detail) {
		FournisseurRestauration frs = fournisseurRestaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FournisseurRestauration", "id", id));
		frs.setAdresse(detail.getAdresse());
		frs.setFax(detail.getFax());
		frs.setGSM(detail.getGSM());
		frs.setMail(detail.getMail());
		frs.setNom(detail.getNom());
		frs.setPrenom(detail.getPrenom());
		return fournisseurRestaurationRepository.save(frs);
	}

	@DeleteMapping(value = "/fournisseurRestauration/delete/{id}")
	public ResponseEntity<?> deleteFournisseurRestauration(@PathVariable(value = "id") Long id) {
		FournisseurRestauration frs = fournisseurRestaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FournisseurRestauration", "id", id));
		fournisseurRestaurationRepository.delete(frs);
		return ResponseEntity.ok().build();
	}
}
