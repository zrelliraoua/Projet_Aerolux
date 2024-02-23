package tn.esprit.aerolux.test;

import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.Utils.MyDatabase;
import tn.esprit.aerolux.controllers.VolController;
import tn.esprit.aerolux.services.VolService;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;



public class Main {


    public static void main(String[] args) throws SQLException {
        VolService volService = new VolService();


      //  Vol v = new Vol(dateDepart,dateArrive,"description","String numVol",1,"d","z",2);
        //     public Vol(Date dateDepart, Date dateArrive, String description, String numVol, Integer piloteId, String lieuArrivee, String lieuDepart, Integer placeDispo) {

     //  try {
            // Ajouter un vol
          //    Vol v1 = new Vol("2023-12-01", "2023-12-01", "description12", "vol4", 5, "lieuArrivee2", "lieuDepart2", 100);
         //     volService.ajouter(v1);

            // Mettre à jour un vol
       /*    List<Vol> vols = volService.recuperer();
            if (!vols.isEmpty()) {
                Vol volToUpdate = vols.get(0); // Récupérer le premier vol pour la mise à jour (ou utiliser un autre mécanisme pour obtenir le vol à mettre à jour)
                volToUpdate.setDescription("nouvelle description");
                volService.update(volToUpdate);
            } else {
                System.out.println("Aucun vol trouvé pour la mise à jour.");
            }*/
           try {
               // Récupérer un vol par son ID (par exemple, ID = 1)
               int volId = 1; // ID du vol à récupérer
               Vol vol = volService.findById(volId);

               if (vol != null) {
                   // Modifier une propriété du vol (dans cet exemple, la description)
                   vol.setDescription("Nouvelle description");

                   // Appeler la méthode update pour mettre à jour le vol dans la base de données
                   volService.update(vol);

                   System.out.println("Le vol a été mis à jour avec succès.");
               } else {
                   System.out.println("Aucun vol trouvé pour l'ID spécifié.");
               }
           } catch (SQLException e) {
               e.printStackTrace();




            // Supprimer un vol (supposons que l'ID du vol à supprimer est 1)
          //  volService.delete(1);

      //      System.out.println(volService.recuperer());
     //   } catch (SQLException e) {
          //  System.err.println( "Une erreur s'est produite :  " + e.getMessage());
        }
    }
}

   /* volService.ajouter(v);
}catch (SQLException e){
    System.err.println(e.getMessage());
}
    }
}*/