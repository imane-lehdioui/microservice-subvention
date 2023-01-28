package com.cm.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_impression")
public class Impression {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double quantite;
	private String service;
	private double totalHt;
	private double totalTTC;

	private String note;
	private Date  dateImpression; 
	private String typeService;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "SUB_id", nullable = true, unique = true)
	private Subvention subvention;

	@OneToMany(mappedBy = "impression", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("impression")
	private Set<TypeImpression> typeImpressions;

	@ManyToOne
	@JoinColumn(name = "FOURNI_id", nullable = true)
	@JsonIgnoreProperties("impression")
	private FournisseurImpression fournisseurImpression;


	
	public Impression() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Impression(double quantite, double totalHt, double totalTTC, Subvention subvention,
			FournisseurImpression fournisseurImpression) {
		super();
		this.quantite = quantite;
		this.totalHt = totalHt;
		this.totalTTC = totalTTC;
		this.subvention = subvention;
		this.fournisseurImpression = fournisseurImpression;
	}
	
	

	

	public Impression(double quantite, String service, double totalHt, double totalTTC, String note,
			Date dateImpression, String typeService, Subvention subvention, Set<TypeImpression> typeImpressions,
			FournisseurImpression fournisseurImpression) {
		super();
		this.quantite = quantite;
		this.service = service;
		this.totalHt = totalHt;
		this.totalTTC = totalTTC;
		this.note = note;
		this.dateImpression = dateImpression;
		this.typeService = typeService;
		this.subvention = subvention;
		this.typeImpressions = typeImpressions;
		this.fournisseurImpression = fournisseurImpression;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDateImpression() {
		return dateImpression;
	}

	public void setDateImpression(Date dateImpression) {
		this.dateImpression = dateImpression;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public double getTotalHt() {
		return totalHt;
	}

	public void setTotalHt(double totalHt) {
		this.totalHt = totalHt;
	}

	public double getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(double totalTTC) {
		this.totalTTC = totalTTC;
	}

	// @JsonIgnore
	public Subvention getSubvention() {
		return subvention;
	}

	public void setSubvention(Subvention subvention) {
		this.subvention = subvention;
	}

	@JsonIgnore
	public Set<TypeImpression> getTypeImpressions() {
		return typeImpressions;
	}

	public void setTypeImpressions(Set<TypeImpression> typeImpressions) {
		this.typeImpressions = typeImpressions;
	}

	public FournisseurImpression getFournisseurImpression() {
		return fournisseurImpression;
	}

	public void setFournisseurImpression(FournisseurImpression fournisseurImpression) {
		this.fournisseurImpression = fournisseurImpression;
	}

}
