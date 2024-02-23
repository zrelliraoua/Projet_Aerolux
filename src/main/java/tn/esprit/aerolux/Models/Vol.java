package tn.esprit.aerolux.Models;


import java.sql.Date;

public class Vol {

    private Integer id;
    private String dateDepart;

    private String dateArrive;
    private String description;

    private String numVol;
    private Integer piloteId;

    private String lieuArrivee;
    private String lieuDepart;
    private Integer placeDispo;
    private String hotelName;
    private String hotelAddress ;

    public Vol(String dateDepart, String dateArrive, String description, String numVol, Integer piloteId, String lieuArrivee, String lieuDepart, Integer placeDispo, String hotelName ,String hotelAddress){
    this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
        this.description = description;
        this.numVol = numVol;
        this.piloteId = piloteId;
        this.lieuArrivee = lieuArrivee;
        this.lieuDepart = lieuDepart;
        this.placeDispo = placeDispo;
        this.hotelName = hotelName;
        this.hotelAddress=hotelAddress;

    }

    public Vol() {
        // Par exemple, initialisation de vos attributs à des valeurs par défaut
        this.id = 0;
        this.dateDepart = null;
        this.dateArrive = null;
        this.description = "";
        this.numVol = "";
        this.piloteId = 0;
        this.lieuArrivee = "";
        this.lieuDepart = "";
        this.placeDispo = 0;
    }



    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", dateDepart=" + dateDepart +
                ", dateArrive=" + dateArrive +
                ", description='" + description + '\'' +
                ", numVol='" + numVol + '\'' +
                ", piloteId=" + piloteId +
                ", lieuArrivee='" + lieuArrivee + '\'' +
                ", lieuDepart='" + lieuDepart + '\'' +
                ", placeDispo=" + placeDispo +
                '}';
    }
    public String getHotelName() {
        return hotelName;
    }
    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public int getPiloteId() {
        return piloteId;
    }

    public void setPiloteId(int piloteId) {
        this.piloteId = piloteId;
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

    public String getPlaceDispo() {
        return String.valueOf(placeDispo);
    }

    public void setPlaceDispo(Integer placeDispo) {
        this.placeDispo = placeDispo;
    }


}