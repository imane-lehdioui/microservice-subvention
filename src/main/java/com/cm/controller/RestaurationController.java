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
import com.cm.entity.Restauration;
import com.cm.entity.Subvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.RestaurationRepository;
import com.cm.repository.SubventionRepository;

@RestController
public class RestaurationController {

	@Autowired
	private RestaurationRepository restaurationRepository;

	@Autowired
	private SubventionRepository subv;

	@GetMapping(value = "/restauration/index")
	public List<Restauration> getAllRestauration() {
		return restaurationRepository.findAll();
	}

	@GetMapping(value = "/restauration/index/{id}")
	public List<Restauration> getAllRestaurationById(@PathVariable(value = "id") Long subId) {
		List<Subvention> subList = subv.findByIdAssociationOrderByIdDesc(subId);
		List<Restauration> restolist = new ArrayList<Restauration>();
		for (Subvention sub : subList) {
			if (sub.getRestauration() != null)
				restolist.add(sub.getRestauration());
		}
		// restaurationRepository.findBySubventionOrderByIdDesc(subList.get(0))
		return restolist;
	}

	@GetMapping(value = "/restauration/showBy/{id}")
	public Restauration getRestaurationShowById(@PathVariable(value = "id") Long id) {
		return restaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restauration", "id", id));
	}

	@GetMapping(value = "/restauration/show/{id}")
	public SubventionBean getRestaurationById(@PathVariable(value = "id") Long id) {
		Restauration rest = restaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restauration", "id", id));
		Subvention sub = subv.findById(rest.getSubvention().getId()).orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
		SubventionBean sb = new SubventionBean();
		sb.setIdSubvention(sub.getId());
		sb.setId(sub.getId());
		sb.setAnneeSubvention(sub.getAnneeSubvention());
		sb.setDateSortSubvention(sub.getDateSortSubvention());
		//sb.setEtatSubvention(sub.getEtatSubvention());
		sb.setIdAssociation(sub.getIdAssociation());
		sb.setNote(sub.getNote());
		sb.setNombrePersonne(rest.getNombrepersonne());
		sb.setTotalHT(rest.getTotalHT());
		sb.setTotalTTC(rest.getTotalTTC());
		sb.setFournisseur(
				rest.getFournisseurRestauration().getNom() + " " + rest.getFournisseurRestauration().getPrenom());
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

	@PostMapping(value = "/restauration/new")
	public Restauration createRestauration(@Valid @RequestBody Restauration Restauration) {
		return restaurationRepository.save(Restauration);
	}

	@PutMapping(value = "/restauration/edit/{id}")
	public Restauration updateRestauration(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Restauration detail) {
		Restauration res = restaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restauration", "id", id));
		res.setFournisseurRestauration(detail.getFournisseurRestauration());
		res.setNombrepersonne(detail.getNombrepersonne());
		res.setSubvention(detail.getSubvention());
		res.setTotalHT(detail.getTotalHT());
		res.setTotalTTC(detail.getTotalTTC());
		return restaurationRepository.save(res);
	}

	@DeleteMapping(value = "/restauration/delete/{id}")
	public ResponseEntity<?> deleteRestauration(@PathVariable(value = "id") Long id) {
		Restauration res = restaurationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Restauration", "id", id));
		restaurationRepository.delete(res);
		return ResponseEntity.ok().build();
	}
}
