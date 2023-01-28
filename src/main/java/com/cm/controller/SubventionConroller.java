package com.cm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.cm.beans.SaerchSubventionDTO;
import com.cm.beans.subventionStatbean;
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
import com.cm.entity.Subvention;
import com.cm.exception.ResourceNotFoundException;
import com.cm.repository.SubventionRepository;

@RestController
public class SubventionConroller {
	@Autowired
	private SubventionRepository subventionRepository;
	//@Autowired
	//private HebergementRepository hebRepo;
	//@Autowired
	//private TypeChambreRepository typeChRepo;

	static long idSub;

	@GetMapping(value = "/subvention/index")
	public List<Subvention> getAllSubvention() {
		return subventionRepository.findAll();
	}

	@GetMapping(value = "/subvention/index/{id}")
	public List<Subvention> getAllSubventionById(@PathVariable(value = "id") Long subId) {
		List<Subvention> list = subventionRepository.findByIdAssociationOrderByIdDesc(subId);
		List<Subvention> subList = new ArrayList<Subvention>();
		// SubventionBean subb =new SubventionBean();
/*		for (Subvention sub : list) {
			if (sub.getTypeSubvention().getId() == 1) {
				// subb.setDateSortSubvention(sub.getDateSortSubvention());
				// subb.setDateSubvention(sub.getDateSubvention());
				// subb.setMontantSubvention(sub.getMontantSubvention());
				// subb.setNote(sub.getNote());
				subList.add(sub);
			}

		}*/
		return list;

	}
	
	@GetMapping(value = "/subventionFinance/index/{id}")
	public List<Subvention> getAllSubventionFinById(@PathVariable(value = "id") Long subId) {
		List<Subvention> list = subventionRepository.findByIdAssociationOrderByIdDesc(subId);
		List<Subvention> subList = new ArrayList<Subvention>();
		// SubventionBean subb =new SubventionBean();
for (Subvention sub : list) {
	if (sub.getHebergement() == null && sub.getImpression() == null && sub.getRestauration() == null && sub.getDivers() == null) {
			
				subList.add(sub);
			}

		}
		return subList;

	}
	

	@GetMapping(value = "/subvention/showBy/{id}")
	public Subvention getSubventionShowById(@PathVariable(value = "id") Long id) {
		return subventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
	}

	@GetMapping(value = "/subvention/show/{id}")
	public SubventionBean getSubventionById(@PathVariable(value = "id") Long id) {
		Subvention sub = subventionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
		SubventionBean sb = new SubventionBean();
		sb.setId(sub.getId());
		sb.setAnneeSubvention(sub.getAnneeSubvention());
		sb.setDateSortSubvention(sub.getDateSortSubvention());
		//sb.setEtatSubvention(sub.getEtatSubvention());
		sb.setMontantSubvention(sub.getMontantSubvention());
		sb.setIdAssociation(sub.getIdAssociation());
		sb.setNote(sub.getNote());
		// 03.08.2020
		sb.setAdresse(sub.getAdresse());
		sb.setDateConseil(sub.getDateConseil());
		sb.setDateDepotDemande(sub.getDateDepotDemande());
//		sb.setDecisionSub(sub.getDecisionSub());
		sb.setNomProjet(sub.getNomProjet());
		sb.setResponsableProjet(sub.getResponsableProjet());
		sb.setTelResProjet(sub.getTelResProjet());
		sb.setDureeprojet(sub.getDureeprojet());
		sb.setMontantDemande(sub.getMontantDemande());
		// 10.11.20
		sb.setCreationDate(sub.getCreationDate());
		sb.setUpdateDate(sub.getUpdateDate());
		sb.setFullName(sub.getCreateurUser());
		sb.setModificateurUser(sub.getModificateurUser());
		sb.setStatutProjet(sub.getStatutProjet());
		return sb;
	}

	@PostMapping(value = "/subvention/new")
	public long createSubvention(@Valid @RequestBody SubventionBean sv) {
		Subvention sub = new Subvention();
		sub.setStatutProjet(sv.getStatutProjet());
		sub.setDateSortSubvention(sv.getDateSortSubvention());
		sub.setAnneeSubvention(sv.getAnneeSubvention());
		//sub.setEtatSubvention(sv.getEtatSubvention());
		sub.setMontantSubvention(sv.getMontantSubvention());
		sub.setNote(sv.getNote());
		sub.setTypePrestAo(sv.getTypePrestAo());
		
		//sub.setTypeSubvention(sv.getTypeSubvention());
		sub.setIdAssociation(sv.getIdAssociation());
		if (sv.getSousTypeSub() != null)
			sub.setSousTypeSub(sv.getSousTypeSub());
		if (sv.getHebergement() != null && sv.getHebergement().getOrganismeAccueil() != null) {
			sub.setHebergement(sv.getHebergement());
		}
		if (sv.getRestauration() != null && sv.getRestauration().getFournisseurRestauration() != null) {
			sub.setRestauration(sv.getRestauration());
		}
		if (sv.getImpression() != null && sv.getImpression().getFournisseurImpression() != null) {
			sub.setImpression(sv.getImpression());
		}
		// 03.08.2020
		if (sv.getDivers() != null) {
			sub.setDivers(sv.getDivers());
		}
		sub.setAdresse(sv.getAdresse());
		sub.setDateConseil(sv.getDateConseil());
		sub.setDateDepotDemande(sv.getDateDepotDemande());
//		sub.setDecisionSub(sv.getDecisionSub());
		sub.setNomProjet(sv.getNomProjet());
		sub.setResponsableProjet(sv.getResponsableProjet());
		sub.setTelResProjet(sv.getTelResProjet());
		sub.setDureeprojet(sv.getDureeprojet());
		sub.setMontantDemande(sv.getMontantDemande());
		// 10.11.20
		sub.setCreateurUser(sv.getFullName());
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		sub.setCreationDate(sqlDate);
		sub.setGid(sv.getGid());
		sub = subventionRepository.save(sub);
		idSub = sub.getId();
		return idSub;
	}

	@PutMapping(value = "/subvention/edit/{id}")
	public Subvention updateSubvention(@PathVariable(value = "id") Long id, @Valid @RequestBody Subvention detail) {
		Subvention sub = subventionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subvention", "id", id));
		sub.setDateSortSubvention(detail.getDateSortSubvention());
		sub.setStatutProjet(detail.getStatutProjet());
		sub.setAnneeSubvention(detail.getAnneeSubvention());
		//sub.setEtatSubvention(detail.getEtatSubvention());
		sub.setIdAssociation(detail.getIdAssociation());
		sub.setMontantSubvention(detail.getMontantSubvention());
		sub.setNote(detail.getNote());
		// 03.08.2020
		sub.setAdresse(detail.getAdresse());
		sub.setDateConseil(detail.getDateConseil());
		sub.setDateDepotDemande(detail.getDateDepotDemande());
		sub.setNomProjet(detail.getNomProjet());
		sub.setResponsableProjet(detail.getResponsableProjet());
		sub.setTelResProjet(detail.getTelResProjet());
		sub.setDureeprojet(detail.getDureeprojet());
		sub.setMontantDemande(detail.getMontantDemande());
		// 10.11.20
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		sub.setUpdateDate(sqlDate);
		sub.setModificateurUser(detail.getModificateurUser());
		return subventionRepository.save(sub);
	}

	@PostMapping(value = "/subvention/stats")
	public List<subventionStatbean> getAllNbrCourrierEntrantByParam(@RequestBody SaerchSubventionDTO saerch ) throws ParseException {
		System.out.println(saerch.getDateDebut());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(saerch.getDateDebut()));
		Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(saerch.getDateFin()));
		return subventionRepository.getStatBydateAndstatutAndArron(saerch.getStatutProjet(),date1,date2);
	}
	@PostMapping(value = "/subvention/getStatSUbvenstionByAss/{id}")
	public List<Subvention> getStatSUbvenstionByAss(@PathVariable("id") Long id , @RequestBody SaerchSubventionDTO saerch) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(saerch.getDateDebut()));
		Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sdf.format(saerch.getDateFin()));
		return subventionRepository.getStatSUbvenstionByAss(id,date1,date2);
	}
}
