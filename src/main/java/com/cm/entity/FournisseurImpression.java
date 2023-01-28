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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * SICM SUBVENTION
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_fournisseurImpression")
public class FournisseurImpression {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String fax;
	private String mail;
	private String GSM;

	@OneToMany(mappedBy = "fournisseurImpression", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("fournisseurImpression")
	private Set<Impression> impressions;

	public FournisseurImpression() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FournisseurImpression(String nom, String prenom, String adresse, String fax, String mail, String gSM) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.fax = fax;
		this.mail = mail;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	public String getGSM() {
		return GSM;
	}

	public void setGSM(String gSM) {
		GSM = gSM;
	}

	@JsonIgnore
	public Set<Impression> getImpressions() {
		return impressions;
	}

	public void setImpressions(Set<Impression> impressions) {
		this.impressions = impressions;
	}

}
