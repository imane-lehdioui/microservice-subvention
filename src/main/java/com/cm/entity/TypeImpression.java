package com.cm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_typeImpression")
public class TypeImpression {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String designation;
	private int quantite;
	private double prixUnitaire;
	private double totalHT;
	private double totalTTC;

	@ManyToOne
	@JoinColumn(name = "IMPRESS_id", nullable = false)
	@JsonIgnoreProperties("typeImpressions")
	private Impression impression;

	public TypeImpression() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeImpression(String designation, int quantite, double prixUnitaire, double totalHT, double totalTTC,
			Impression impression) {
		super();
		this.designation = designation;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.totalHT = totalHT;
		this.totalTTC = totalTTC;
		this.impression = impression;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(double totalHT) {
		this.totalHT = totalHT;
	}

	public double getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(double totalTTC) {
		this.totalTTC = totalTTC;
	}

	// @JsonIgnore
	public Impression getImpression() {
		return impression;
	}

	public void setImpression(Impression impression) {
		this.impression = impression;
	}

}
