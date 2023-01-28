package com.cm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_divers")
public class Divers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String designation;
	private double quantite;
	private String unite;
	private double prix;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "SUB_id", nullable = true, unique = true)
	private Subvention subvention;

	public Divers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Divers(String designation, double quantite, String unite, double prix, Subvention subvention) {
		super();
		this.designation = designation;
		this.quantite = quantite;
		this.unite = unite;
		this.prix = prix;
		this.subvention = subvention;
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

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Subvention getSubvention() {
		return subvention;
	}

	public void setSubvention(Subvention subvention) {
		this.subvention = subvention;
	}

}
