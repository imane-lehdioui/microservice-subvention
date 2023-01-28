package com.cm.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * SICM SUBVENTION
 * 
 * @author R.SABRI
 * @version 2021
 *
 */
@Entity
@Table(name = "sub_subvention")
public class Subvention {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	// private Date dateSubvention;
	private String anneeSubvention;
	private String gid;
	private double montantSubvention;
	private long idAssociation;
	private String note;
	private Date dateSortSubvention; // date de transfer du montant
	private String sousTypeSub;
	// Ajouter le 27/07/20
	private Date dateDepotDemande;
	private Date dateConseil;
	private String nomProjet;
	private String adresse;
	private String responsableProjet;
	private String telResProjet;
	// @Column(nullable =true)
	private double dureeprojet;
	// private String decisionSub;
	// @Column(nullable =true)
	private double montantDemande;

	private Date creationDate;
	private Date updateDate;
	private String createurUser;
	private String modificateurUser;
	
	private String typePrestAo;
	//« statut du projet »
     private  long statutProjet;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subvention")
	private Restauration restauration;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subvention")
	private Hebergement hebergement;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subvention")
	private Impression impression;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "subvention")
	private Divers divers;

	@ManyToOne
	@JoinColumn(name = "TYPSUB_id", nullable = true)
	private TypeSubvention typeSubvention;
/*
	@ManyToOne
	@JoinColumn(name = "ETASUB_id", nullable = true)
	private EtatSubvention etatSubvention;
*/
	public Subvention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getStatutProjet() {
		return statutProjet;
	}

	public void setStatutProjet(long statutProjet) {
		this.statutProjet = statutProjet;
	}

	public Subvention(long id, String anneeSubvention, String gid, double montantSubvention, long idAssociation, String note, Date dateSortSubvention, String sousTypeSub, Date dateDepotDemande, Date dateConseil, String nomProjet, String adresse, String responsableProjet, String telResProjet, double dureeprojet, double montantDemande, Date creationDate, Date updateDate, String createurUser, String modificateurUser, String typePrestAo, long statutProjet, Restauration restauration, Hebergement hebergement, Impression impression, Divers divers, TypeSubvention typeSubvention) {
		this.id = id;
		this.anneeSubvention = anneeSubvention;
		this.gid = gid;
		this.montantSubvention = montantSubvention;
		this.idAssociation = idAssociation;
		this.note = note;
		this.dateSortSubvention = dateSortSubvention;
		this.sousTypeSub = sousTypeSub;
		this.dateDepotDemande = dateDepotDemande;
		this.dateConseil = dateConseil;
		this.nomProjet = nomProjet;
		this.adresse = adresse;
		this.responsableProjet = responsableProjet;
		this.telResProjet = telResProjet;
		this.dureeprojet = dureeprojet;
		this.montantDemande = montantDemande;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.createurUser = createurUser;
		this.modificateurUser = modificateurUser;
		this.typePrestAo = typePrestAo;
		this.statutProjet = statutProjet;
		this.restauration = restauration;
		this.hebergement = hebergement;
		this.impression = impression;
		this.divers = divers;
		this.typeSubvention = typeSubvention;
	}

	public Subvention(String anneeSubvention, String gid, double montantSubvention, long idAssociation, String note,
					  Date dateSortSubvention, String sousTypeSub, Date dateDepotDemande, Date dateConseil, String nomProjet,
					  String adresse, String responsableProjet, String telResProjet, double dureeprojet,
					  Restauration restauration, Hebergement hebergement, Impression impression, TypeSubvention typeSubvention,
					  Divers divers, double montantDemande, Date creationDate, Date updateDate,
					  String userCreation, String modificateurUser) {
		super();
		this.anneeSubvention = anneeSubvention;
		this.gid=gid;
		this.montantSubvention = montantSubvention;
		this.idAssociation = idAssociation;
		this.note = note;
		this.dateSortSubvention = dateSortSubvention;
		this.sousTypeSub = sousTypeSub;
		this.dateDepotDemande = dateDepotDemande;
		this.dateConseil = dateConseil;
		this.nomProjet = nomProjet;
		this.adresse = adresse;
		this.responsableProjet = responsableProjet;
		this.telResProjet = telResProjet;
		this.dureeprojet = dureeprojet;
		this.restauration = restauration;
		this.hebergement = hebergement;
		this.impression = impression;
		this.typeSubvention = typeSubvention;
		this.divers = divers;
		this.montantDemande = montantDemande;
		this.createurUser = userCreation;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.modificateurUser = modificateurUser;
	}

	
	public String getTypePrestAo() {
		return typePrestAo;
	}

	public void setTypePrestAo(String typePrestAo) {
		this.typePrestAo = typePrestAo;
	}

	public String getAnneeSubvention() {
		return anneeSubvention;
	}

	public void setAnneeSubvention(String anneeSubvention) {
		this.anneeSubvention = anneeSubvention;
	}

	public String getSousTypeSub() {
		return sousTypeSub;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateurUser() {
		return createurUser;
	}

	public void setCreateurUser(String createurUser) {
		this.createurUser = createurUser;
	}

	public void setSousTypeSub(String sousTypeSub) {
		this.sousTypeSub = sousTypeSub;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMontantSubvention() {
		return montantSubvention;
	}

	public void setMontantSubvention(double montantSubvention) {
		this.montantSubvention = montantSubvention;
	}

	public long getIdAssociation() {
		return idAssociation;
	}

	public void setIdAssociation(long idAssociation) {
		this.idAssociation = idAssociation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDateSortSubvention() {
		return dateSortSubvention;
	}

	public void setDateSortSubvention(Date dateSortSubvention) {
		this.dateSortSubvention = dateSortSubvention;
	}

	@JsonIgnore
	public Restauration getRestauration() {
		return restauration;
	}

	public void setRestauration(Restauration restauration) {
		if (restauration == null) {
			if (this.restauration != null) {
				this.restauration.setSubvention(null);
			}
		} else {
			restauration.setSubvention(this);
		}
		this.restauration = restauration;
	}

	@JsonIgnore
	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergement hebergement) {
		if (hebergement == null) {
			if (this.hebergement != null) {
				this.hebergement.setSubvention(null);
			}
		} else {
			hebergement.setSubvention(this);
		}
		this.hebergement = hebergement;
	}

	public TypeSubvention getTypeSubvention() {
		return typeSubvention;
	}

	public void setTypeSubvention(TypeSubvention typeSubvention) {
		this.typeSubvention = typeSubvention;
	}

/*	public EtatSubvention getEtatSubvention() {
		return etatSubvention;
	}

	public void setEtatSubvention(EtatSubvention etatSubvention) {
		this.etatSubvention = etatSubvention;
	}
*/
	@JsonIgnore
	public Impression getImpression() {
		return impression;
	}

	public void setImpression(Impression impression) {
		if (impression == null) {
			if (this.impression != null) {
				this.impression.setSubvention(null);
			}
		} else {
			impression.setSubvention(this);
		}
		this.impression = impression;
	}

	public Date getDateDepotDemande() {
		return dateDepotDemande;
	}

	public void setDateDepotDemande(Date dateDepotDemande) {
		this.dateDepotDemande = dateDepotDemande;
	}

	public Date getDateConseil() {
		return dateConseil;
	}

	public void setDateConseil(Date dateConseil) {
		this.dateConseil = dateConseil;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getResponsableProjet() {
		return responsableProjet;
	}

	public void setResponsableProjet(String responsableProjet) {
		this.responsableProjet = responsableProjet;
	}

	public String getTelResProjet() {
		return telResProjet;
	}

	public void setTelResProjet(String telResProjet) {
		this.telResProjet = telResProjet;
	}

	@JsonIgnore
	public Divers getDivers() {
		return divers;
	}

	public void setDivers(Divers divers) {
		if (divers == null) {
			if (this.divers != null) {
				this.divers.setSubvention(null);
			}
		} else {
			divers.setSubvention(this);
		}
		this.divers = divers;

	}

	public double getDureeprojet() {
		return dureeprojet;
	}

	public void setDureeprojet(double dureeprojet) {
		this.dureeprojet = dureeprojet;
	}

	public double getMontantDemande() {
		return montantDemande;
	}

	public void setMontantDemande(double montantDemande) {
		this.montantDemande = montantDemande;
	}

	public String getModificateurUser() {
		return modificateurUser;
	}

	public void setModificateurUser(String modificateurUser) {
		this.modificateurUser = modificateurUser;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	
}