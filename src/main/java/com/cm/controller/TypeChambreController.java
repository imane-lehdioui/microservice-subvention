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

import com.cm.entity.Hebergement;
import com.cm.entity.TypeChambre;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.HebergementRepository;
import com.cm.repository.TypeChambreRepository;

@RestController
public class TypeChambreController {

	@Autowired
	private TypeChambreRepository typechambreRepository;
	
	@Autowired
	private HebergementRepository hebergementRepository;
	
	@GetMapping(value = "/typeChambre/index")
	public List<TypeChambre> getAllTypeChambre() {
		return typechambreRepository.findAll();
	}
	
	@GetMapping(value = "/typeChambre/hebergement/{id}")
	public List<TypeChambre> getAllTypeChambreByHeberegement(@PathVariable(value = "id") Long id) {
		Hebergement heber = hebergementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hebergement", "id", id));
		List<TypeChambre> listCh = typechambreRepository.findByHebergementOrderByIdDesc(heber);
		return listCh;
	}

	@GetMapping(value = "/typeChambre/show/{id}")
	public TypeChambre getTypeChambreById(@PathVariable(value = "id") Long typeId) {
		return typechambreRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeChambre", "typeId", typeId));
	}

	@PostMapping(value = "/typeChambre/new")
	public TypeChambre createTypeChambre(@Valid @RequestBody TypeChambre typeChambre) {
		return typechambreRepository.save(typeChambre);
	}

	@PutMapping(value = "/typeChambre/edit/{id}")
	public TypeChambre updateTypeChambre(@PathVariable(value = "id") Long typeId,
			@Valid @RequestBody TypeChambre detail) {
		TypeChambre typeChambre = typechambreRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeChambre", "typeId", typeId));

		typeChambre.setDesignation(detail.getDesignation());
		typeChambre.setHebergement(detail.getHebergement());
		typeChambre.setPrixUnitaire(detail.getPrixUnitaire());
		typeChambre.setQuantite(detail.getQuantite());
		typeChambre.setTotalHT(detail.getTotalHT());
		typeChambre.setTotalTTC(detail.getTotalTTC());
		return typechambreRepository.save(typeChambre);
	}

	@DeleteMapping(value = "/typeChambre/delete/{id}")
	public ResponseEntity<?> deleteTypeChambre(@PathVariable(value = "id") Long typeId) {
		TypeChambre typeChambre = typechambreRepository.findById(typeId)
				.orElseThrow(() -> new ResourceNotFoundException("TypeChambre", "typeId", typeId));
		typechambreRepository.delete(typeChambre);
		return ResponseEntity.ok().build();
	}
}
