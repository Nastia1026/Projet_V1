package miniprojet.projet_v1.model.controller.dashboard;

import miniprojet.projet_v1.model.*;
import javafx.fxml.FXML;
import java.util.Map;
import java.util.HashMap;
import javafx.scene.control.*;
import java.time.LocalTime;
import java.util.List;

public class AdminDashboardController {
    private Administrateur admin;

    // Composants FXML corrects
    @FXML private TextField nomCoursField;
    @FXML private TextArea statsArea; // Ajoutez cette ligne
    @FXML private ComboBox<Matiere> matiereCombo;
    @FXML private ComboBox<Salle> salleCombo;
    @FXML
    private void handleGenererStats() {
        statsArea.clear();
        Map<String, Integer> stats = admin.genererStatistiques();
        stats.forEach((key, value) ->
                statsArea.appendText(key + " : " + value + "\n")
        );
    }
    @FXML
    private void handleCreerCours() { // Nom de méthode corrigé
        try {
            // Création du créneau avec syntaxe valide
            Creneau creneau = new Creneau(
                    "Lundi",
                    LocalTime.of(14, 0), // Syntaxe numérique correcte
                    LocalTime.of(16, 0)
            );

            Cours nouveauCours = admin.creerCours(
                    nomCoursField.getText(), // Variable exacte
                    matiereCombo.getValue(),
                    List.of(creneau),
                    salleCombo.getValue() // Référence correcte
            );

            afficherMessage("Cours créé : " + nouveauCours.getNom());
        } catch (Exception e) {
            afficherErreur("Données incomplètes !"); // Méthode corrigée
        }
    }

    private void afficherMessage(String message) {
        new Alert(Alert.AlertType.INFORMATION, message).show();
    }

    private void afficherErreur(String message) { // Nom corrigé
        new Alert(Alert.AlertType.ERROR, message).show();
    }

    public void setAdmin(Administrateur admin) {
        this.admin = admin; // Utilisé quand on charge le contrôleur
    }
}