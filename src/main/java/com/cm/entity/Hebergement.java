package com.cm.entity;

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
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_hebergement")
public class Hebergement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int nombrePersonne;
	private double nombreNuitee;
	private int nombreChambre;
	private double totalHt;
	private double totalTTC;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "SUB_id", nullable = true, unique = true)
	private Subvention subvention;

	@OneToMany(mappedBy = "hebergement", cascade = CascadeType.ALL)
	private Set<TypeChambre> typeChambres;

	@ManyToOne
	@JoinColumn(name = "ORGANISM_id", nullable = true)
	private OrganismeAccueil organismeAccueil;

	public Hebergement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hebergement(int nombrePersonne, double nombreNuitee, int nombreChambre, double totalHt, double totalTTC,
			Subvention subvention, OrganismeAccueil organismeAccueil) {
		super();
		this.nombrePersonne = nombrePersonne;
		this.nombreNuitee = nombreNuitee;
		this.nombreChambre = nombreChambre;
		this.totalHt = totalHt;
		this.totalTTC = totalTTC;
		this.subvention = subvention;
		this.organismeAccueil = organismeAccueil;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public double getNombreNuitee() {
		return nombreNuitee;
	}

	public void setNombreNuitee(double nombreNuitee) {
		this.nombreNuitee = nombreNuitee;
	}

	public int getNombreChambre() {
		return nombreChambre;
	}

	public void setNombreChambre(int nombreChambre) {
		this.nombreChambre = nombreChambre;
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

	public OrganismeAccueil getOrganismeAccueil() {
		return organismeAccueil;
	}

	public void setOrganismeAccueil(OrganismeAccueil organismeAccueil) {
		this.organismeAccueil = organismeAccueil;
	}

	@JsonIgnore
	public Set<TypeChambre> getTypeChambres() {
		return typeChambres;
	}

	public void setTypeChambres(Set<TypeChambre> typeChambres) {
		this.typeChambres = typeChambres;
	}

}