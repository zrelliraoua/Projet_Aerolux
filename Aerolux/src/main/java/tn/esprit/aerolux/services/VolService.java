package tn.esprit.aerolux.services;

import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.Utils.MyDatabase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class VolService implements IService<Vol> {
    private Connection connection;

    public VolService() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Vol vol) throws SQLException {
        String req = "INSERT INTO Vol (numVol, dateDepart, dateArrive) VALUES ('" +
                vol.getNumVol() + "','" +
                vol.getDateDepart() + "','" +
                vol.getDateArrive() + "')";
        Statement st = connection.createStatement();
        st.executeUpdate(req);
    }


    @Override
    public void modifier(Vol vol) {
    }

    @Override
    public void supprimer(int id) {
    }

    @Override
    public List<Vol> recuperer() {
        return null;
    }
}