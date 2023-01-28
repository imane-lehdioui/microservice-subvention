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

import com.cm.entity.FournisseurImpression;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.FournisseurImpressionRepository;

@RestController
public class FournisseurImpressionController {

	@Autowired
	private FournisseurImpressionRepository fourimpressRepo;

	@GetMapping(value = "/fournisseurImpression/index")
	public List<FournisseurImpression> getAllFournisseurImpression() {
		return fourimpressRepo.findByOrderByIdDesc();
	}

	@GetMapping(value = "/fournisseurImpression/show/{id}")
	public FournisseurImpression getFournisseurImpressionById(@PathVariable(value = "id") Long id) {
		return fourimpressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FournisseurImpression", "id", id));
	}

	@PostMapping(value = "/fournisseurImpression/new")
	public FournisseurImpression createFournisseurImpression(
			@Valid @RequestBody FournisseurImpression FournisseurImpression) {
		return fourimpressRepo.save(FournisseurImpression);
	}

	@PutMapping(value = "/fournisseurImpression/edit/{id}")
	public FournisseurImpression updateFournisseurImpression(@PathVariable(value = "id") Long id,
			@Valid @RequestBody FournisseurImpression detail) {
		FournisseurImpression frs = fourimpressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FournisseurImpression", "id", id));
		frs.setAdresse(detail.getAdresse());
		frs.setFax(detail.getFax());
		frs.setGSM(detail.getGSM());
		frs.setMail(detail.getMail());
		frs.setNom(detail.getNom());
		frs.setPrenom(detail.getPrenom());
		return fourimpressRepo.save(frs);
	}

	@DeleteMapping(value = "/fournisseurImpression/delete/{id}")
	public ResponseEntity<?> deleteFournisseurImpression(@PathVariable(value = "id") Long id) {
		FournisseurImpression frs = fourimpressRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("FournisseurImpression", "id", id));
		fourimpressRepo.delete(frs);
		return ResponseEntity.ok().build();
	}
}
