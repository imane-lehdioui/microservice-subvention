package com.cm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_TypePlat")
public class TypePlat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String designation;
	private int quantite;
	private double prixUnitaire;
	private double totalHT;
	private double totalTTC;

	@ManyToOne
	@JoinColumn(name = "RESTAU_id", nullable = false)
	private Restauration restauration;

	public TypePlat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypePlat(String designation, int quantite, double prixUnitaire, double totalHT, double totalTTC,
			Restauration restauration) {
		super();
		this.designation = designation;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.totalHT = totalHT;
		this.totalTTC = totalTTC;
		this.restauration = restauration;
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
	public Restauration getRestauration() {
		return restauration;
	}

	public void setRestauration(Restauration restauration) {
		this.restauration = restauration;
	}

}