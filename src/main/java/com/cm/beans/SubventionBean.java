package com.cm.beans;

import java.util.Date;

import com.cm.entity.Divers;
//import com.cm.entity.EtatSubvention;
import com.cm.entity.Hebergement;
import com.cm.entity.Impression;
import com.cm.entity.Restauration;
import com.cm.entity.Subvention;
import com.cm.entity.TypeSubvention;

public class SubventionBean {

	private long id;
	// private Date dateSubvention;
	private String anneeSubvention;
	private String gid;
	private double montantSubvention;
	private long idAssociation;
	private String note;
	private Date dateSortSubvention;
	private String sousTypeSub;
	private Restauration restauration;
	private Hebergement hebergement;
	private TypeSubvention typeSubvention;
//	private EtatSubvention etatSubvention;
	private Impression impression;

	private int nombrePersonne;
	private double nombreNuitee;
	private int nombreChambre;
	private double totalTTC;
	private Subvention subvention;
	private String typeChambre;
	private String designation;
	private double prixUnitaire;
	private double quantite;
	private double totalHT;
	private String fournisseur;
	private String organismeAcceuil;
	private long idSubvention;

	// 03.08.2020
	private Date dateDepotDemande;
	private Date dateConseil;
	private String nomProjet;
	private String adresse;
	private String responsableProjet;
	private String telResProjet;
	private double dureeprojet;
	private String decisionSub;
	private double montantDemande;
	private Divers divers;

	private String unite;

	// 10.11.2020
	private String fullName;
	private Date creationDate;
	private Date updateDate;
	private String modificateurUser;

	private String typePrestAo;
	private  long statutProjet;

	public long getStatutProjet() {
		return statutProjet;
	}

	public void setStatutProjet(long statutProjet) {
		this.statutProjet = statutProjet;
	}

	public String getTypePrestAo() {
		return typePrestAo;
	}

	public void setTypePrestAo(String typePrestAo) {
		this.typePrestAo = typePrestAo;
	}

	public String getModificateurUser() {
		return modificateurUser;
	}

	public void setModificateurUser(String modificateurUser) {
		this.modificateurUser = modificateurUser;
	}

	public long getIdSubvention() {
		return idSubvention;
	}

	public void setIdSubvention(long idSubvention) {
		this.idSubvention = idSubvention;
	}

	public String getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(String typeChambre) {
		this.typeChambre = typeChambre;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getOrganismeAcceuil() {
		return organismeAcceuil;
	}

	public void setOrganismeAcceuil(String organismeAcceuil) {
		this.organismeAcceuil = organismeAcceuil;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnneeSubvention() {
		return anneeSubvention;
	}

	public void setAnneeSubvention(String anneeSubvention) {
		this.anneeSubvention = anneeSubvention;
	}

	public double getMontantSubvention() {
		return montantSubvention;
	}

	public Impression getImpression() {
		return impression;
	}

	public void setImpression(Impression impression) {
		this.impression = impression;
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

	public String getSousTypeSub() {
		return sousTypeSub;
	}

	public void setSousTypeSub(String sousTypeSub) {
		this.sousTypeSub = sousTypeSub;
	}

	public Restauration getRestauration() {
		return restauration;
	}

	public void setRestauration(Restauration restauration) {
		this.restauration = restauration;
	}

	public Hebergement getHebergement() {
		return hebergement;
	}

	public void setHebergement(Hebergement hebergement) {
		this.hebergement = hebergement;
	}

	public TypeSubvention getTypeSubvention() {
		return typeSubvention;
	}

	public void setTypeSubvention(TypeSubvention typeSubvention) {
		this.typeSubvention = typeSubvention;
	}

	/*public EtatSubvention getEtatSubvention() {
		return etatSubvention;
	}

	public void setEtatSubvention(EtatSubvention etatSubvention) {
		this.etatSubvention = etatSubvention;
	}
*/
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

	public double getTotalTTC() {
		return totalTTC;
	}

	public void setTotalTTC(double totalTTC) {
		this.totalTTC = totalTTC;
	}

	public Subvention getSubvention() {
		return subvention;
	}

	public void setSubvention(Subvention subvention) {
		this.subvention = subvention;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public double getQuantite() {
		return quantite;
	}

	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}

	public double getTotalHT() {
		return totalHT;
	}

	public void setTotalHT(double totalHT) {
		this.totalHT = totalHT;
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

	public double getDureeprojet() {
		return dureeprojet;
	}

	public void setDureeprojet(double dureeprojet) {
		this.dureeprojet = dureeprojet;
	}

	public String getDecisionSub() {
		return decisionSub;
	}

	public void setDecisionSub(String decisionSub) {
		this.decisionSub = decisionSub;
	}

	public double getMontantDemande() {
		return montantDemande;
	}

	public void setMontantDemande(double montantDemande) {
		this.montantDemande = montantDemande;
	}

	public Divers getDivers() {
		return divers;
	}

	public void setDivers(Divers divers) {
		this.divers = divers;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	
	
}
