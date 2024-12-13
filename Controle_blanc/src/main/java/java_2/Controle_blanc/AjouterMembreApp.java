package java_2.Controle_blanc;

import daoimpl.MembreDaoImpl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Membre;

public class AjouterMembreApp extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
        Label titleLabel = new Label("Ajouter un nouveau membre");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField nomField = new TextField();
        nomField.setPromptText("Nom");

        TextField prenomField = new TextField();
        prenomField.setPromptText("Prénom");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone");

        Button insererButton = new Button("Insérer");
        insererButton.setOnAction(e -> {
            String nom = nomField.getText();
            String prenom = prenomField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Tous les champs doivent être remplis !");
                alert.show();
            } else {
                Membre membre = new Membre(nom, prenom, email, phone);
            	MembreDaoImpl membreimpl = new MembreDaoImpl();
            	membreimpl.Insere(membre);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Membre ajouté avec succès !");
                alert.show();
                // Vous pouvez ici insérer ces données dans la base de données
                 
            }
        });

        // Organisation des éléments dans une VBox
        VBox root = new VBox(10, titleLabel, nomField, prenomField, emailField, phoneField, insererButton);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f5f5f5; -fx-border-radius: 10; -fx-background-radius: 10;");

        // Création de la scène et affichage
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Ajouter un membre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
