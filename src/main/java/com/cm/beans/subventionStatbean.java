package com.cm.beans;

public class subventionStatbean {

    private long nbSubention;
    private long SatutProject;
    private long nom;

    public subventionStatbean() {
    }

    public subventionStatbean(long nbSubention, long satutProject) {
        this.nbSubention = nbSubention;
        SatutProject = satutProject;
    }

    public subventionStatbean(long nbSubention, long satutProject, long nom) {
        this.nbSubention = nbSubention;
        SatutProject = satutProject;
        this.nom = nom;
    }

    public long getNom() {
        return nom;
    }

    public void setNom(long nom) {
        this.nom = nom;
    }

    public long getNbSubention() {
        return nbSubention;
    }

    public void setNbSubention(long nbSubention) {
        this.nbSubention = nbSubention;
    }

    public long getSatutProject() {
        return SatutProject;
    }

    public void setSatutProject(long satutProject) {
        SatutProject = satutProject;
    }
}
