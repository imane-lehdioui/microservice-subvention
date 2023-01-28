package com.cm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_etatSubvention")
public class EtatSubvention {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	@Column(nullable = true)
	private int etat;

	/*
	@OneToMany(mappedBy = "etatSubvention", cascade = CascadeType.ALL)
	private Set<Subvention> subventions;
*/
	public EtatSubvention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EtatSubvention(String libelle, int etat) {
		super();
		this.libelle = libelle;
		this.etat = etat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

}