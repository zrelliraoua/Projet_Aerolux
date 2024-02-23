package tn.esprit.aerolux.services;

import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.Utils.MyDatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class VolService implements IService<Vol> {
    private Connection connection;
    public VolService(){
        connection = MyDatabase.getInstance().getConnection();
    }

   /* @Override
    public void ajouter(Vol vol) throws SQLException {

        try {
            PreparedStatement pst = connection.prepareStatement("INSERT INTO vol (piloteId, numVol, lieuArrivee, lieuDepart, placeDispo, description, dateArrivee, dateDepart) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, vol.getPiloteId());
            pst.setString(2, vol.getNumVol());
            pst.setString(3, vol.getLieuArrivee());
            pst.setString(4, vol.getLieuDepart());
            pst.setString(5, vol.getPlaceDispo());
            pst.setString(6, vol.getDescription());
            pst.setDate(7, vol.getDateArrive());
            pst.setDate(8, vol.getDateDepart());
            pst.executeUpdate();
            System.out.println("vol ajouté");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
*/
    @Override
    public void ajouter(Vol vol) throws SQLException {
        String req = "insert into vol ( NumVol,LieuArrivee ,piloteId , LieuDepart ,PlaceDispo  ,Description ,DateArrive,DateDepart) " +
                "values( '"+vol.getNumVol()+"','"+vol.getLieuArrivee()+"','"+vol.getPiloteId()+"','"+vol.getLieuDepart()+"','"+vol.getPlaceDispo()+"','"+vol.getDescription()+"','"+vol.getDateArrive()+"','"+vol.getDateDepart()+"')";

        Statement st = connection.createStatement();
        st.executeUpdate(req);

    }
    @Override
    public void update(Vol vol) throws  SQLException{
        String req = "update vol set NumVol = ? ,  LieuArrivee = ?  , LieuDepart = ? , piloteId = ? ,PlaceDispo = ?, Description = ?, DateArrive = ?, DateDepart = ?  where id = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1 , vol.getNumVol());
        ps.setString(2 , vol.getLieuArrivee());
        ps.setString(3 , vol.getLieuDepart());
        ps.setInt(4,vol.getPiloteId());
        ps.setString(5 , vol.getPlaceDispo());
        ps.setString(6 , vol.getDescription());
        ps.setString(7 , vol.getDateArrive());
        ps.setString(8,vol.getDateDepart());
        ps.setInt(9, vol.getId());
        ps.executeUpdate();

    }
    @Override
    public List<Vol> rechercher(String lieu) throws SQLException {
        List<Vol> vols = new ArrayList<>();
        String req = "SELECT * FROM vol WHERE LieuDepart LIKE ? OR LieuArrivee LIKE ? OR description LIKE ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, "%" + lieu + "%");
        ps.setString(2, "%" + lieu + "%");
        ps.setString(3, "%" + lieu + "%");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Vol vol = new Vol();
            vol.setId(result.getInt("id"));
            vol.setNumVol(result.getString("numVol"));
            vol.setPlaceDispo(result.getInt("placeDispo"));
            vol.setDescription(result.getString("description"));
            vol.setLieuDepart(result.getString("LieuDepart"));
            vol.setLieuArrivee(result.getString("lieuArrivee"));
            vol.setPlaceDispo(Integer.valueOf(result.getString("placeDispo")));
            vol.setDateDepart(result.getString("dateDepart"));
            vol.setPiloteId(Integer.parseInt(result.getString("piloteId")));
            vol.setDateArrive(result.getString("dateArrive"));
            vols.add(vol);
        }
        // Fermer les ressources
        result.close();
        ps.close();
        return vols;
    }
    @Override
    public Vol findById(int id) throws SQLException {
        Vol vol = null;
        String req = "SELECT * FROM vol WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Construire l'objet Vol à partir des données de la base de données
            vol = new Vol(
                    rs.getString("DateArrive"),
                    rs.getString("DateDepart"),
                    rs.getString("Description"),
                    rs.getString("NumVol"),
                    rs.getInt("PiloteId"),
                    rs.getString("LieuArrivee"),
                    rs.getString("LieuDepart"),
                    rs.getInt("PlaceDispo"),
                    rs.getString("hotelName"),
                    rs.getString("hotelAdress")


                    );
            vol.setId(rs.getInt("id"));
        }
        // Fermer les ressources
        rs.close();
        ps.close();
        return vol;
    }
    @Override
    public void supprimer(int id)  throws  SQLException{
        String req = "DELETE FROM vol WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1,id);
        ps.executeUpdate();
    }
    @Override
    public List<Vol> recuperer() throws  SQLException{
        List <Vol> vols = new ArrayList<>();
        String req ="select * from vol";
        Statement st = connection.createStatement();
        ResultSet result = st.executeQuery(req);
        while (result.next()){
            Vol vol = new Vol();
            vol.setId(result.getInt("id"));
            vol.setNumVol(result.getString("numVol"));
            vol.setPlaceDispo(result.getInt("placeDispo"));
            vol .setDescription(result.getString("description"));
            vol.setLieuDepart(result.getString("LieuDepart"));
            vol.setLieuArrivee(result.getString("lieuArrivee"));
            vol.setPlaceDispo(Integer.valueOf(result.getString("placeDispo")));
            vol.setDateDepart(result.getString("dateDepart"));
            vol.setPiloteId(Integer.parseInt(result.getString("piloteId")));
            vol.setDateArrive(result.getString("dateArrive"));





          vols.add(vol);

        }
        return vols ;
    }

}

  /*  @Override
    public void modifier(Vol vol) throws SQLException {
        try {
            PreparedStatement pst = connection.prepareStatement("UPDATE vol SET placeDispo = ?, description = ?, numVol = ?, lieuDepart = ?, lieuArrivee = ? WHERE id = ?");
            pst.setString(1, vol.getPlaceDispo());
            pst.setString(2, vol.getDescription());
            pst.setString(3, vol.getNumVol());
            pst.setString(4, vol.getLieuDepart());
            pst.setString(5, vol.getLieuArrivee());
            pst.setInt(6, vol.getId());
            pst.executeUpdate();
            System.out.println("vol modifié");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


   /* @Override
    public void supprimer(Vol vol) throws SQLException {
        try{
            PreparedStatement pst = MyDatabase.getInstance().getConnection().prepareStatement("DELETE FROM vol WHERE id = ?");
            pst.setInt(1, vol.getId());
            pst.executeUpdate();
            System.out.println("Avion supprimé");

        }catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

  /*  @Override
    public List<Vol> recuperer()throws SQLException {
        List<Vol> vols = new ArrayList<>();
        try {
            String req = "SELECT * FROM vol";
            ResultSet res = connection.createStatement().executeQuery(req);
            while (res.next()) {
                int id = res.getInt("id");
                String description = res.getString("description");
                String numVol = res.getString("numvol");
                String lieuDepart = res.getString("lieuDepart");
                String lieuArrivee = res.getString("lieuArrivee");

                Vol v = new Vol(id, numVol, lieuDepart, lieuArrivee, description);
                vols.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vols;
    }


    @Override
    public Vol findbyId(int id) throws SQLException {
        Vol vol = null;
        try {
            String req = "SELECT * FROM vol WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                String description = res.getString("description");
                String numVol = res.getString("numvol");
                String lieuDepart = res.getString("lieuDepart");
                String lieuArrivee = res.getString("lieuArrivee");

                vol = new Vol(id, numVol, lieuDepart, lieuArrivee, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vol;
    }*/
