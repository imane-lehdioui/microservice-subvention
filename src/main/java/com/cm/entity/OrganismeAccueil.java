package com.cm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "sub_organismeAccueil")
public class OrganismeAccueil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String adresse;
	private String fax;
	private String mail;
	private String RC;
	private String GSM;

	@OneToMany(mappedBy = "organismeAccueil", cascade = CascadeType.ALL)
	private Set<Hebergement> hebergements;

	public OrganismeAccueil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrganismeAccueil(String nom, String adresse, String fax, String mail, String rC, String gSM) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.fax = fax;
		this.mail = mail;
		RC = rC;
		GSM = gSM;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adtresse) {
		this.adresse = adtresse;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getRC() {
		return RC;
	}

	public void setRC(String rC) {
		RC = rC;
	}

	public String getGSM() {
		return GSM;
	}

	public void setGSM(String gSM) {
		GSM = gSM;
	}

}