package miniprojet.projet_v1.model;

import java.util.ArrayList;
import java.util.List;

public class Enseignant extends Utilisateur {
    // Attributs
    private List<Matiere> matieresEnseignees = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();

    // Constructeurs
    public Enseignant() {
    }

    public Enseignant(String id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Implémentation des méthodes abstraites
    @Override
    public boolean authentifier() {
        return this.email != null && !this.email.isEmpty()
                && this.motDePasse != null && !this.motDePasse.isEmpty();
    }

    @Override
    public List<Creneau> consulterEmploiDuTemps() {
        // Implémentation temporaire
        return new ArrayList<>();
    }

    // Méthode spécifique
    public void signalerAnomalie(String description) {
        if (description != null && !description.trim().isEmpty()) {
            System.out.println("Anomalie signalée: " + description);
        }
    }

    // Getters/Setters
    public List<Matiere> getMatieresEnseignees() {
        return matieresEnseignees;
    }

    public void setMatieresEnseignees(List<Matiere> matieresEnseignees) {
        this.matieresEnseignees = matieresEnseignees;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}