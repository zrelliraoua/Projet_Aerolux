package tn.esprit.aerolux.services;

import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.Utils.MyDatabase;

import java.sql.Connection;
import java.util.List;

public class VolService implements IService<Vol> {
    private Connection connection;

    public VolService(){
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Vol vol) {
        String req = "INSERT INTO Vol (nom,prenom,age) VALUES ('"+vol.getNumVol()+"','"+vol.getDateDepart()+"','"+vol.getDateArrive())";
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