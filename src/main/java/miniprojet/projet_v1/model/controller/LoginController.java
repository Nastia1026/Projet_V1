package miniprojet.projet_v1.model.controller;

import miniprojet.projet_v1.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginController {
    // Éléments FXML
    @FXML private VBox loginContainer;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Label errorLabel;

    // Service d'authentification (à créer)
    private final AuthService authService = new AuthService();

    @FXML
    private void handleLogin() {
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        if (email.isEmpty() || password.isEmpty()) {
            showError("Veuillez remplir tous les champs");
            return;
        }

        Utilisateur user = authService.authenticate(email, password);

        if (user != null) {
            redirectBasedOnUserType(user);
        } else {
            showError("Identifiants incorrects");
        }
    }

    private void redirectBasedOnUserType(Utilisateur user) {
        try {
            if (user instanceof Administrateur) {
                redirectToAdminDashboard((Administrateur) user);
            } else if (user instanceof Enseignant) {
                redirectToTeacherDashboard((Enseignant) user);
            } else if (user instanceof Etudiant) {
                redirectToStudentDashboard((Etudiant) user);
            }
        } catch (Exception e) {
            showError("Erreur de navigation : " + e.getMessage());
        }
    }

    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
        loginContainer.getStyleClass().add("error");
    }

    // Méthodes de redirection (à implémenter)
    private void redirectToAdminDashboard(Administrateur admin) throws Exception { /* ... */ }
    private void redirectToTeacherDashboard(Enseignant enseignant) throws Exception { /* ... */ }
    private void redirectToStudentDashboard(Etudiant etudiant) throws Exception { /* ... */ }
}