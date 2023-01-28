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
@Table(name = "sub_restauration")
public class Restauration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int nombrepersonne;
	private double totalHT;
	private double totalTTC;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "SUB_id", nullable = true, unique = true)
	private Subvention subvention;

	@OneToMany(mappedBy = "restauration", cascade = CascadeType.ALL)
	private Set<TypePlat> typePlats;

	@ManyToOne
	@JoinColumn(name = "FOURNI_id", nullable = true)
	private FournisseurRestauration fournisseurRestauration;

	public Restauration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restauration(int nombrepersonne, double totalHT, double totalTTC, Subvention subvention,
			FournisseurRestauration fournisseurRestauration) {
		super();
		this.nombrepersonne = nombrepersonne;
		this.totalHT = totalHT;
		this.totalTTC = totalTTC;
		this.subvention = subvention;
		this.fournisseurRestauration = fournisseurRestauration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNombrepersonne() {
		return nombrepersonne;
	}

	public void setNombrepersonne(int nombrepersonne) {
		this.nombrepersonne = nombrepersonne;
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
	public Subvention getSubvention() {
		return subvention;
	}

	public void setSubvention(Subvention subvention) {
		this.subvention = subvention;
	}

	public FournisseurRestauration getFournisseurRestauration() {
		return fournisseurRestauration;
	}

	public void setFournisseurRestauration(FournisseurRestauration fournisseurRestauration) {
		this.fournisseurRestauration = fournisseurRestauration;
	}

	@JsonIgnore
	public Set<TypePlat> getTypePlats() {
		return typePlats;
	}

	public void setTypePlats(Set<TypePlat> typePlats) {
		this.typePlats = typePlats;
	}

}