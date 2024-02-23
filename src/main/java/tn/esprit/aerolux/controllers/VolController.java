package tn.esprit.aerolux.controllers;

import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.services.VolService;

import java.sql.SQLException;
import java.util.List;

public class VolController {
    private VolService volService;

/*    public VolController() {
        volService = new VolService();
    }

    public void ajouterVol(Vol vol) {
        try {
            volService.ajouter(vol);
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du vol : " + e.getMessage());
        }
    }

    public void modifierVol(Vol vol) {
        try {
            volService.modifier(vol);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification du vol : " + e.getMessage());
        }
    }

    public void supprimerVol(Vol vol) {
        try {
            volService.supprimer(vol);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du vol : " + e.getMessage());
        }
    }

    public List<Vol> recupererVols() {
        try {
            return volService.recuperer();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la récupération des vols : " + e.getMessage());
            return null;
        }
    }

    public Vol trouverVolParId(int id) {
        try {
            return volService.findbyId(id);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche du vol par ID : " + e.getMessage());
            return null;
        }
    }*/
}
