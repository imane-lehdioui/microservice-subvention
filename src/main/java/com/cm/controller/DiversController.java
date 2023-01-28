package com.cm.controller;

import java.util.ArrayList;
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

import com.cm.beans.SubventionBean;
import com.cm.entity.Divers;
import com.cm.entity.Subvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.DiversRepository;
import com.cm.repository.SubventionRepository;

@RestController
public class DiversController {

	@Autowired
	private SubventionRepository subv;
	
	@Autowired
	private DiversRepository divRepository;
	
	@GetMapping(value = "/divers/index")
	public List<Divers> getAllOtherServices() {
		return divRepository.findAll();
	}

	@GetMapping(value = "/divers/index/{id}")
	public List<Divers> getAllOtherServicesById(@PathVariable(value = "id") Long subId) {
		List<Subvention> subList = subv.findByIdAssociationOrderByIdDesc(subId);
		List<Divers> restolist = new ArrayList<Divers>();
		for (Subvention sub : subList) {
			if (sub.getDivers() != null)
				restolist.add(sub.getDivers());
		}
		return restolist;
	}

	@GetMapping(value = "/divers/showBy/{id}")
	public Divers getOtherServicesShowById(@PathVariable(value = "id") Long id) {
		return divRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Divers", "id", id));
	}

	@GetMapping(value = "/divers/show/{id}")
	public SubventionBean getOtherServicesById(@PathVariable(value = "id") Long id) {
		Divers div = divRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Divers", "id", id));
		Subvention sub = subv.findById(div.getSubvention().getId()).orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
		SubventionBean sb = new SubventionBean();
		sb.setIdSubvention(sub.getId());
		sb.setId(sub.getId());
		sb.setAnneeSubvention(sub.getAnneeSubvention());
		sb.setDateSortSubvention(sub.getDateSortSubvention());
		//sb.setEtatSubvention(sub.getEtatSubvention());
		sb.setIdAssociation(sub.getIdAssociation());
		sb.setNote(sub.getNote());
		// 08.08.20
		sb.setSousTypeSub(sub.getSousTypeSub());
		sb.setDesignation(div.getDesignation());
		sb.setQuantite(div.getQuantite());
		sb.setPrixUnitaire(div.getPrix());
		sb.setUnite(div.getUnite());
		// 03.08.2020
		sb.setMontantSubvention(sub.getMontantSubvention());
		sb.setAdresse(sub.getAdresse());
		sb.setDateConseil(sub.getDateConseil());
		sb.setDateDepotDemande(sub.getDateDepotDemande());
//		sb.setDecisionSub(sub.getDecisionSub());
		sb.setNomProjet(sub.getNomProjet());
		sb.setResponsableProjet(sub.getResponsableProjet());
		sb.setTelResProjet(sub.getTelResProjet());
		sb.setDureeprojet(sub.getDureeprojet());
		sb.setMontantDemande(sub.getMontantDemande());
		sb.setCreationDate(sub.getCreationDate());
		sb.setUpdateDate(sub.getUpdateDate());
		sb.setFullName(sub.getCreateurUser());
		sb.setModificateurUser(sub.getModificateurUser());
		return sb;
	}

	@PostMapping(value = "/divers/new")
	public Divers createOtherServices(@Valid @RequestBody Divers Restauration) {
		return divRepository.save(Restauration);
	}

	@PutMapping(value = "/divers/edit/{id}")
	public Divers updateOtherServices(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Divers detail) {
		Divers div = divRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Divers", "id", id));
		// 08.08.20
		div.setDesignation(detail.getDesignation());
		div.setQuantite(detail.getQuantite());
		div.setPrix(detail.getPrix());
		div.setUnite(detail.getUnite());
		div.setSubvention(detail.getSubvention());
		return divRepository.save(div);
	}

	@DeleteMapping(value = "/divers/delete/{id}")
	public ResponseEntity<?> deleteOtherServices(@PathVariable(value = "id") Long id) {
		Divers res = divRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Divers", "id", id));
		divRepository.delete(res);
		return ResponseEntity.ok().build();
	}
}

