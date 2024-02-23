package tn.esprit.aerolux.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tn.esprit.aerolux.Models.Vol;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class DetailsVolController {

    @FXML
    private Label hotelNameLabel;

    // Autres champs et méthodes de votre contrôleur

    @FXML
    private Hyperlink mapLink;

    public void initData(Vol vol) {
        // Utilisez les données du vol pour afficher le nom de l'hôtel
        String hotelName = vol.getHotelName();
        hotelNameLabel.setText(hotelName);

        // Utilisez l'adresse de l'hôtel pour générer l'URL de la carte Google Maps
        String address = vol.getHotelAddress();
        String mapUrl = generateGoogleMapsUrl(address);

        // Affichez le lien vers la carte Google Maps dans votre interface utilisateur
        mapLink.setText("Voir sur Google Maps");
        mapLink.setOnAction(e -> {
            // Ouvrez le navigateur web ou une vue web avec l'URL de la carte
            openWebPage(mapUrl);
        });
    }

    // Méthode pour générer l'URL de la carte Google Maps à partir de l'adresse
    private String generateGoogleMapsUrl(String address) {
        // Construisez l'URL en utilisant l'adresse fournie
        // Assurez-vous d'utiliser l'API Google Maps pour générer cette URL
        // Exemple d'URL : "https://www.google.com/maps/search/?api=1&query=address"
        return "https://www.google.com/maps/search/?api=1&query=" + address;
    }

    // Méthode pour ouvrir une page web dans le navigateur par défaut
    private void openWebPage(String url) {
        try {
            // Utilisez la classe Desktop pour ouvrir l'URL dans le navigateur par défaut
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}


