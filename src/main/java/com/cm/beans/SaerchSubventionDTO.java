package com.cm.beans;

import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public class SaerchSubventionDTO {


    List<Long> statutProjet;
    Date dateDebut;
    Date   dateFin;


    public SaerchSubventionDTO() {
    }

    public SaerchSubventionDTO(List<Long> statutProjet, Date dateDebut, Date dateFin) {
        this.statutProjet = statutProjet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public List<Long> getStatutProjet() {
        return statutProjet;
    }

    public void setStatutProjet(List<Long> statutProjet) {
        this.statutProjet = statutProjet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDDebut) {
        this.dateDebut = dateDDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
