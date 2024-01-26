package tn.esprit.aerolux.Models;

import java.sql.Date;

public class Vol {
    private Integer id;
    private Date dateDepart;
    private Date dateArrive;
    private String numVol;
    private String lieuArrivee;
    private String lieuDepart;
    private Integer placeDispo;

    public Vol(Integer id, Date dateDepart, Date dateArrive, String numVol, String lieuArrivee, String lieuDepart, Integer placeDispo) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.numVol = numVol;
        this.lieuArrivee = lieuArrivee;
        this.lieuDepart = lieuDepart;
        this.placeDispo = placeDispo;
    }

    public Vol(Date dateDepart, Date dateArrive, String numVol, String lieuArrivee, String lieuDepart, Integer placeDispo) {
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.numVol = numVol;
        this.lieuArrivee = lieuArrivee;
        this.lieuDepart = lieuDepart;
        this.placeDispo = placeDispo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public String getLieuArrivee() {
        return lieuArrivee;
    }

    public void setLieuArrivee(String lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public Integer getPlaceDispo() {
        return placeDispo;
    }

    public void setPlaceDispo(Integer placeDispo) {
        this.placeDispo = placeDispo;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", dateDepart=" + dateDepart +
                ", dateArrive=" + dateArrive +
                ", numVol='" + numVol + '\'' +
                ", lieuArrivee='" + lieuArrivee + '\'' +
                ", lieuDepart='" + lieuDepart + '\'' +
                ", placeDispo=" + placeDispo +
                '}';
    }
}
