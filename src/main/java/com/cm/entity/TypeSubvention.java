package com.cm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_TypeSubvention")
public class TypeSubvention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;

	@OneToMany(mappedBy = "typeSubvention", cascade = CascadeType.ALL)
	private Set<Subvention> subventions;

	@OneToMany(mappedBy = "typeSubvention", cascade = CascadeType.ALL)
	private Set<SousTypeSubvention> sousTypeSubventions;

	public TypeSubvention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeSubvention(String libelle) {
		super();
		this.libelle = libelle;
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

	@JsonIgnore
	public Set<SousTypeSubvention> getSousTypeSubventions() {
		return sousTypeSubventions;
	}

	public void setSousTypeSubventions(Set<SousTypeSubvention> sousTypeSubventions) {
		this.sousTypeSubventions = sousTypeSubventions;
	}

}