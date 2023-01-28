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
import com.cm.entity.Hebergement;
import com.cm.entity.Subvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.HebergementRepository;
import com.cm.repository.SubventionRepository;

@RestController
public class HebergementController {

	@Autowired
	private HebergementRepository hebergementRepository;
	@Autowired
	private SubventionRepository subv;
	

	@GetMapping(value = "/hebergement/index")
	public List<Hebergement> getAllHebergement() {
		return hebergementRepository.findByOrderByIdDesc();
	}

	@GetMapping(value = "/hebergement/index/{id}")
	public List<Hebergement> getAllHebergementById(@PathVariable(value = "id") Long subId) {
		List<Subvention> subList = subv.findByIdAssociationOrderByIdDesc(subId);
		List<Hebergement> heberglist = new ArrayList<Hebergement>();
		for (Subvention sub : subList) {
			if (sub.getHebergement() != null)
				heberglist.add(sub.getHebergement());
		}
		return heberglist;
	}

	@GetMapping(value = "/hebergement/showBy/{id}")
	public Hebergement getHebergementShowById(@PathVariable(value = "id") Long id) {
		return hebergementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hebergement", "id", id));
	}

	@GetMapping(value = "/hebergement/show/{id}")
	public SubventionBean getRestaurationById(@PathVariable(value = "id") Long id) {
		Hebergement heb = hebergementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hebergement", "id", id));
		Subvention sub = subv.findById(heb.getSubvention().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
		SubventionBean sb = new SubventionBean();
		sb.setIdSubvention(sub.getId());
		sb.setId(sub.getId());
		sb.setAnneeSubvention(sub.getAnneeSubvention());
		sb.setDateSortSubvention(sub.getDateSortSubvention());
		//sb.setEtatSubvention(sub.getEtatSubvention());
		sb.setIdAssociation(sub.getIdAssociation());
		sb.setNote(sub.getNote());
		sb.setNombreChambre(heb.getNombreChambre());
		sb.setNombreNuitee(heb.getNombreNuitee());
		sb.setNombrePersonne(heb.getNombrePersonne());
		sb.setTotalHT(heb.getTotalHt());
		sb.setTotalTTC(heb.getTotalTTC());
		sb.setOrganismeAcceuil(heb.getOrganismeAccueil().getNom());
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

	@PostMapping(value = "/hebergement/new")
	public Hebergement createHebergement(@Valid @RequestBody Hebergement heber) {
		return hebergementRepository.save(heber);
	}

	@PutMapping(value = "/hebergement/edit/{id}")
	public Hebergement updateHebergement(@PathVariable(value = "id") Long id, @Valid @RequestBody Hebergement detail) {
		Hebergement heber = hebergementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hebergement", "id", id));
		heber.setNombreChambre(detail.getNombreChambre());
		heber.setNombreNuitee(detail.getNombreNuitee());
		heber.setNombrePersonne(detail.getNombrePersonne());
		heber.setOrganismeAccueil(detail.getOrganismeAccueil());
		heber.setSubvention(detail.getSubvention());
		heber.setTotalHt(detail.getTotalHt());
		heber.setTotalTTC(detail.getTotalTTC());
		return hebergementRepository.save(heber);
	}

	@DeleteMapping(value = "/hebergement/delete/{id}")
	public ResponseEntity<?> deleteHebergement(@PathVariable(value = "id") Long id) {
		Hebergement heber = hebergementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hebergement", "id", id));
		hebergementRepository.delete(heber);
		return ResponseEntity.ok().build();
	}
}
