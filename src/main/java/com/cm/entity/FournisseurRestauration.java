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
@Table(name = "sub_fournisseurRestauration")
public class FournisseurRestauration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String fax;
	private String mail;
	private String GSM;

	@OneToMany(mappedBy = "fournisseurRestauration", cascade = CascadeType.ALL)
	private Set<Restauration> restaurations;

	public FournisseurRestauration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FournisseurRestauration(String nom, String prenom, String adresse, String fax, String mail, String gSM) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.fax = fax;
		this.mail = mail;
		this.GSM = gSM;
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
		this.GSM = gSM;
	}

}