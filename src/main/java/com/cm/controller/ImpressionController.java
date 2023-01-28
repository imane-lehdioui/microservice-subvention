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
import com.cm.entity.Impression;
import com.cm.entity.Subvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.ImpressionRepository;
import com.cm.repository.SubventionRepository;

@RestController
public class ImpressionController {

	@Autowired
	private ImpressionRepository impressionRepository;

	@Autowired
	private SubventionRepository subv;

	@GetMapping(value = "/impression/index")
	public List<Impression> getAllImpression() {
		return impressionRepository.findAll();
	}

	@GetMapping(value = "/impression/index/{id}")
	public List<Impression> getAllImpressionById(@PathVariable(value = "id") Long subId) {
		List<Subvention> subList = subv.findByIdAssociationOrderByIdDesc(subId);
		List<Impression> restolist = new ArrayList<Impression>();
		for (Subvention sub : subList) {
			if (sub.getImpression() != null)
				restolist.add(sub.getImpression());
		}
		// impressionRepository.findBySubventionOrderByIdDesc(subList.get(0))
		return restolist;
	}

	@GetMapping(value = "/impression/showBy/{id}")
	public Impression getImpressionShowById(@PathVariable(value = "id") Long id) {
		return impressionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Impression", "id", id));
	}

	@GetMapping(value = "/impression/show/{id}")
	public SubventionBean getImpressionById(@PathVariable(value = "id") Long id) {
		Impression rest = impressionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Impression", "id", id));
		Subvention sub = subv.findById(rest.getSubvention().getId()).orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
		SubventionBean sb = new SubventionBean();
		sb.setIdSubvention(sub.getId());
		sb.setId(sub.getId());
		sb.setAnneeSubvention(sub.getAnneeSubvention());
		sb.setDateSortSubvention(sub.getDateSortSubvention());
		//sb.setEtatSubvention(sub.getEtatSubvention());
		sb.setIdAssociation(sub.getIdAssociation());
		sb.setNote(sub.getNote());
		sb.setTotalHT(rest.getTotalHt());
		sb.setTotalTTC(rest.getTotalTTC());
		sb.setQuantite(rest.getQuantite());
		sb.setFournisseur(
				rest.getFournisseurImpression().getNom() + " " + rest.getFournisseurImpression().getPrenom());
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

	@PostMapping(value = "/impression/new")
	public Impression createImpression(@Valid @RequestBody Impression Impression) {
		return impressionRepository.save(Impression);
	}

	@PutMapping(value = "/impression/edit/{id}")
	public Impression updateImpression(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Impression detail) {
		Impression res = impressionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Impression", "id", id));
		res.setFournisseurImpression(detail.getFournisseurImpression());
		res.setQuantite(res.getQuantite());
		res.setSubvention(detail.getSubvention());
		res.setTotalHt(detail.getTotalHt());
		res.setTotalTTC(detail.getTotalTTC());
		return impressionRepository.save(res);
	}

	@DeleteMapping(value = "/impression/delete/{id}")
	public ResponseEntity<?> deleteImpression(@PathVariable(value = "id") Long id) {
		Impression res = impressionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Impression", "id", id));
		impressionRepository.delete(res);
		return ResponseEntity.ok().build();
	}
}
