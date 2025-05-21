package miniprojet.projet_v1.model;

import java.util.ArrayList;
import java.util.List;

public class Etudiant extends Utilisateur {
    // Attributs spécifiques
    private String numeroEtudiant;
    private String groupe;
    private List<Notification> notifications = new ArrayList<>();

    // Constructeurs
    public Etudiant() {
    }

    public Etudiant(String id, String nom, String email) {
        this.id = id; // Champ hérité de Utilisateur (protected)
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
        // À implémenter avec la logique réelle plus tard
        return new ArrayList<>();
    }

    // Méthode spécifique de l'UML
    public void recevoirNotification(Notification notification) {
        if (notification != null) {
            notifications.add(notification);
        }
    }

    // Getters/Setters
    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}