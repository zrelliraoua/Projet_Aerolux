package tn.esprit.aerolux.services;

import tn.esprit.aerolux.Models.Reservation;
import tn.esprit.aerolux.Utils.MyDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ReservationService implements IService<Reservation> {
    private Connection connection;

    public ReservationService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    public void ajouter(Reservation reservation) throws SQLException {
        String req = "INSERT INTO reservation (agency_name, trip_id, status, nb_seat, agency_id, price) VALUES " +
                "('"
                + reservation.getAgency_name() + "','"
                + reservation.getTrip_id() + "','"
                + reservation.getStatus() + "',"
                + reservation.getNb_seat() + ",'"
                + reservation.getAgency_id() + "','"
                + reservation.getPrice() + "')";

        Statement st = connection.createStatement();
        st.executeUpdate(req);
    } @Override
    public void modifier(Reservation reservation) {
    }

    @Override
    public void supprimer(int id)  {

    }


    @Override
    public List<Reservation> recuperer() {
        return null;
    }
}
