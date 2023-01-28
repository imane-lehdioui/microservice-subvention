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

import com.cm.entity.OrganismeAccueil;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.OrganismeAccueilRepository;

@RestController
public class OrganismeAccueilController {

	@Autowired
	private OrganismeAccueilRepository organismeAccueilRepository;
	
	@GetMapping(value = "/organismeAccueil/index")
	public List<OrganismeAccueil> getAllOrganismeAccueil() {
		return organismeAccueilRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/organismeAccueil/show/{id}")
	public OrganismeAccueil getOrganismeAccueilById(@PathVariable(value = "id") Long id) {
		return organismeAccueilRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrganismeAccueil", "id", id));
	}

	@PostMapping(value = "/organismeAccueil/new")
	public OrganismeAccueil createOrganismeAccueil(@Valid @RequestBody OrganismeAccueil org) {
		return organismeAccueilRepository.save(org);
	}

	@PutMapping(value = "/organismeAccueil/edit/{id}")
	public OrganismeAccueil updateOrganismeAccueil(@PathVariable(value = "id") Long id,
			@Valid @RequestBody OrganismeAccueil detail) {
		OrganismeAccueil org = organismeAccueilRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrganismeAccueil", "id", id));
		
		org.setAdresse(detail.getAdresse());
		org.setFax(detail.getFax());
		org.setGSM(detail.getGSM());
		org.setMail(detail.getMail());
		org.setNom(detail.getNom());
		org.setRC(detail.getRC());
		
		return organismeAccueilRepository.save(org);
	}

	@DeleteMapping(value = "/organismeAccueil/delete/{id}")
	public ResponseEntity<?> deleteOrganismeAccueil(@PathVariable(value = "id") Long id) {
		OrganismeAccueil sub = organismeAccueilRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("OrganismeAccueil", "id", id));
		organismeAccueilRepository.delete(sub);
		return ResponseEntity.ok().build();
	}
}
