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
@Table(name = "sub_sousTypeSubvention")
public class SousTypeSubvention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;

	@ManyToOne
	@JoinColumn(name = "TYPSUB_id", nullable = true)
	private TypeSubvention typeSubvention;

	public SousTypeSubvention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SousTypeSubvention(String libelle, TypeSubvention typeSubvention) {
		super();
		this.libelle = libelle;
		this.typeSubvention = typeSubvention;
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

	public TypeSubvention getTypeSubvention() {
		return typeSubvention;
	}

	public void setTypeSubvention(TypeSubvention typeSubvention) {
		this.typeSubvention = typeSubvention;
	}

}