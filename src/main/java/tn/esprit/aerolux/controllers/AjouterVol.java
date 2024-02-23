package tn.esprit.aerolux.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import tn.esprit.aerolux.Models.Vol;
import tn.esprit.aerolux.services.VolService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AjouterVol {
    @FXML
    private Button ajouterVolButton;

    @FXML
    private TableColumn<Vol, String> action;
    @FXML
    private TableColumn<Vol, Integer> id;


    @FXML
    private TableColumn<Vol, String> dateArrive;

    @FXML
    private TableColumn<Vol, String> dateDepart;

    @FXML
    private TableColumn<Vol, String> description;

    @FXML
    private TextField rechercher;

    @FXML
    private ImageView home_btn;

    @FXML
    private Button hr_btn;

    @FXML
    private TableColumn<Vol, String> lieuArrivee;

    @FXML
    private TableColumn<Vol, String> lieuDepart;

    @FXML
    private TableColumn<Vol, String> numVol;

    @FXML
    private TableColumn<Vol, Integer> piloteId;

    @FXML
    private TableColumn<Vol, Integer> placeDispo;

    @FXML
    private ImageView profile_btn;

    @FXML
    private Button reservation_btn;

    @FXML
    private Button tips_btn;

    @FXML
    private TableView<Vol> vol_table;

    @FXML
    void switchToHome(ActionEvent event) {

    }

    @FXML
    void switchToReservation(ActionEvent event) {

    }
    private VolService volService = new VolService();

    @FXML
    void initialize() {
        VolService volService1 = new VolService();
        try {
            List<Vol> vols = volService1.recuperer();
            ObservableList<Vol> observableList = FXCollections.observableList(vols);
            vol_table.setItems(observableList);


            // Set cell value factories for each column
            // id.setCellValueFactory(new PropertyValueFactory<>("id"));
            piloteId.setCellValueFactory(new PropertyValueFactory<>("piloteId")); // Utilisez piloteId au lieu de pilote
            placeDispo.setCellValueFactory(new PropertyValueFactory<>("placeDispo")); // Utilisez placeDispo au lieu de nb_place
            dateArrive.setCellValueFactory(new PropertyValueFactory<>("dateArrive")); // Utilisez dateArrive au lieu de date arrivée
            dateDepart.setCellValueFactory(new PropertyValueFactory<>("dateDepart")); // Utilisez dateDepart au lieu de date depart
            lieuDepart.setCellValueFactory(new PropertyValueFactory<>("lieuDepart")); // Utilisez lieuDepart au lieu de lieu depart
            numVol.setCellValueFactory(new PropertyValueFactory<>("numVol")); // Utilisez numVol au lieu de numéro vol
            lieuArrivee.setCellValueFactory(new PropertyValueFactory<>("lieuArrivee")); // Utilisez lieuArrivee au lieu de lieu arrivee


            description.setCellValueFactory(new PropertyValueFactory<>("description")); // Utilisez description au lieu de Description
            rechercher.setOnKeyReleased(event -> {
                String searchQuery = rechercher.getText().trim();
                if (!searchQuery.isEmpty()) {
                    try {
                        List<Vol> searchedVols = volService.rechercher(searchQuery);
                        ObservableList<Vol> observableSearchedList = FXCollections.observableList(searchedVols);
                        vol_table.setItems(observableSearchedList);
                    } catch (SQLException e) {
                        System.err.println("Erreur lors de la recherche des vols: " + e.getMessage());
                    }
                } else {
                    // Si la requête de recherche est vide, réafficher tous les vols
                    vol_table.setItems(observableList);
                }
            });
            action.setCellFactory(column -> {
                return new TableCell<Vol, String>() {
                    private final Button updateButton = new Button("Update");
                    private final Button deleteButton = new Button("Delete");

                    {
                        updateButton.getStyleClass().add("update-button");
                        deleteButton.getStyleClass().add("delete-button");
                        vol_table.setRowFactory(tv -> {
                            TableRow<Vol> row = new TableRow<>();
                            row.setOnMouseClicked(event -> {
                                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                                    Vol selectedVol = row.getItem();
                                    afficherDetailsVol(selectedVol);
                                }
                            });
                            return row;
                        });

                        updateButton.setOnAction(event -> {
                            Vol vol = getTableView().getItems().get(getIndex());

                            // Créez une interface utilisateur (par exemple, une fenêtre de dialogue ou un formulaire) pour permettre à l'utilisateur de modifier les détails du vol
                            // Vous pouvez utiliser les champs du vol pour pré-remplir le formulaire
                            // Lorsque l'utilisateur confirme la modification, récupérez les nouvelles valeurs des champs
                            // Par exemple, supposons que vous avez un dialogue de mise à jour de vol avec des champs de texte pour chaque propriété du vol
                            Dialog<Vol> dialog = new Dialog<>();
                            dialog.setTitle("Update Vol");
                            dialog.setHeaderText("Modify Vol Details");

                            // Créez les champs de texte pour chaque propriété du vol
                            TextField numVolField = new TextField(vol.getNumVol());
                            TextField lieuArriveeField = new TextField(vol.getLieuArrivee());
                            TextField lieuDepartField = new TextField(vol.getLieuDepart());
                            TextField DateDepartField = new TextField(vol.getDateDepart());
                            TextField DateArriveField = new TextField(vol.getDateArrive());

                            // Ajoutez les autres champs de texte pour les autres propriétés du vol

                            // Créez le bouton "Update" pour confirmer la mise à jour
                            ButtonType updateButtonType = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
                            dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

                            // Ajoutez les champs de texte au contenu du dialogue
                            dialog.getDialogPane().setContent(new VBox(8, numVolField, lieuArriveeField, lieuDepartField, DateDepartField, DateArriveField /* Ajoutez les autres champs ici */));

                            // Lorsque l'utilisateur clique sur le bouton "Update", récupérez les nouvelles valeurs des champs et invoquez la méthode update() du service
                            dialog.setResultConverter(dialogButton -> {
                                if (dialogButton == updateButtonType) {
                                    // Récupérez les nouvelles valeurs des champs
                                    String newNumVol = numVolField.getText();
                                    String newLieuArrivee = lieuArriveeField.getText();
                                    String newLieuDepart = lieuDepartField.getText();
                                    String newDateArrivee = DateArriveField.getText();
                                    String newDateDepart = DateDepartField.getText();

                                    // Récupérez les autres valeurs des champs

                                    // Créez un nouvel objet Vol avec les nouvelles valeurs
                                    Vol updatedVol = new Vol();
                                    updatedVol.setId(vol.getId()); // Assurez-vous de définir l'ID du vol
                                    updatedVol.setNumVol(newNumVol);
                                    updatedVol.setLieuArrivee(newLieuArrivee);
                                    updatedVol.setLieuDepart(newLieuDepart);
                                    updatedVol.setDateArrive(newDateArrivee);
                                    updatedVol.setDateDepart(newDateDepart);
                                    // Définissez les autres propriétés du vol

                                    // Invoquez la méthode update() du service avec le vol mis à jour
                                    try {
                                        VolService volService = new VolService();
                                        volService.update(updatedVol);
                                        initialize(); // Actualisez la TableView après la mise à jour
                                    } catch (SQLException e) {
                                        System.err.println("Erreur lors de la mise à jour du vol: " + e.getMessage());
                                    }
                                }
                                return null;
                            });

                            dialog.showAndWait();
                        });

                        deleteButton.setOnAction(event -> {
                            Vol vol = getTableView().getItems().get(getIndex());
                            try {
                                VolService volService = new VolService();
                                volService.supprimer(vol.getId());
                                initialize();
                            } catch (SQLException e) {
                                System.err.println("Erreur lors de la suppression du vol: " + e.getMessage());
                            }
                        });
                    }

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(new HBox(updateButton, deleteButton));
                        }
                    }
                };
            });
            ajouterVolButton.setOnAction(this::afficherPopupAjoutVol);



        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private void afficherDetailsVol(Vol vol) {
        // Créer une fenêtre contextuelle ou une nouvelle fenêtre pour afficher les détails du vol
        // Vous pouvez utiliser FXMLLoader pour charger une nouvelle vue FXML pour afficher les détails du vol
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/aerolux/DetailsVol.fxml"));
            Parent root = loader.load();

            // Passer le vol sélectionné à la nouvelle vue FXML
            DetailsVolController controller = loader.getController();
            controller.initData(vol);

            // Créer une nouvelle scène
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Détails du vol");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'exception de manière appropriée
        }
    }

    @FXML
    void afficherPopupAjoutVol(ActionEvent event) {
        try {
            // Charge le fichier FXML de la fenêtre de dialogue d'ajout de vol
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/tn/esprit/aerolux/AjoutVolPopup.fxml"));
            Parent root = loader.load();

            // Créez un nouveau stage pour la fenêtre de dialogue
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ajouter un nouveau vol");
            stage.setScene(new Scene(root));

            // Affichez la fenêtre de dialogue
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'exception de manière appropriée
        }
    }
}




