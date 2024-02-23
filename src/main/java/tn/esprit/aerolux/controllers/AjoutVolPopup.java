package tn.esprit.aerolux.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.services.VolService;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class AjoutVolPopup {

    @FXML
    private TextField numVolTextField;

    @FXML
    private TextField lieuDepartTextField;

    @FXML
    private TextField lieuArriveeTextField;

    @FXML
    private TextField piloteIdTextField;

    @FXML
    private TextField placeDispoTextField;

    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField hotelAdressTextField ;

    @FXML
    private TextField hotelNameTextField ;

    @FXML
    private DatePicker dateArriveeTextField;

    @FXML
    private DatePicker dateDepartTextField;

    @FXML
    void ajouterVol(ActionEvent event) {
        // Récupérer les valeurs saisies dans les champs de texte
        String numVol = numVolTextField.getText();
        String lieuDepart = lieuDepartTextField.getText();
        String lieuArrivee = lieuArriveeTextField.getText();
        Integer placeDispo = Integer.valueOf(placeDispoTextField.getText());
        String description = descriptionTextField.getText();
        String dateArrivee = String.valueOf(dateArriveeTextField.getValue());
        String dateDepart = String.valueOf(dateDepartTextField.getValue());
        Integer piloteId = Integer.valueOf(piloteIdTextField.getText());
        String hotelName = String.valueOf(hotelNameTextField.getText());
        String hotelAdress = String.valueOf(hotelAdressTextField.getText());


        // Créer un nouvel objet Vol avec ces valeurs
        Vol vol = new Vol(dateArrivee, dateDepart, description, numVol, piloteId, lieuArrivee,lieuDepart, placeDispo,hotelName,hotelAdress);

        // Ajouter le vol à la base de données
        VolService volService = new VolService();
        try {
            volService.ajouter(vol);
            // Fermer la fenêtre de dialogue après l'ajout
            fermerPopup();
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur d'ajout
        }
    }
    @FXML
    void fermerPopup() {
        // Fermer la fenêtre de dialogue
        numVolTextField.getScene().getWindow().hide();
    }
}