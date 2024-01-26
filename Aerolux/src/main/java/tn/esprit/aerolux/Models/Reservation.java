package tn.esprit.aerolux.Models;

import java.util.Date;

public class Reservation {
    private  int id;
    private int trip_id;
    private int agency_id;
    private String agency_name;
    private String status;
    private int nb_seat;

    private float price;
    private Date reservation_date;

    public Reservation(int id, int trip_id, int agency_id, String agency_name, String status, int nb_seat, float price) {
        this.id = id;
        this.trip_id = trip_id;
        this.agency_id = agency_id;
        this.agency_name = agency_name;
        this.status = status;
        this.nb_seat = nb_seat;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public int getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(int agency_id) {
        this.agency_id = agency_id;
    }

    public String getAgency_name() {
        return agency_name;
    }

    public void setAgency_name(String agency_name) {
        this.agency_name = agency_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNb_seat() {
        return nb_seat;
    }

    public void setNb_seat(int nb_seat) {
        this.nb_seat = nb_seat;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }
    @Override
    public String toString(){
        return "Reservation : "
                + "Id" + id
                + ",Agence :"+ agency_name
                +",Nombre de places :" + nb_seat
                +",Etat :" +status
                +"Id Vol :" +trip_id
                +"Prix "+ price;
    }
}
