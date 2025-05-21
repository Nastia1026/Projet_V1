package miniprojet.projet_v1.model;

import java.time.LocalDateTime;

public class Notification {
    // Attributs de l'UML
    private String id;
    private String contenu;
    private LocalDateTime dateEnvoi;

    // Constructeurs
    public Notification() {
    }

    public Notification(String id, String contenu) {
        this.id = id;
        this.contenu = contenu;
        this.dateEnvoi = LocalDateTime.now();
    }

    // Méthode d'envoi (implémentation basique)
    public void envoyer() {
        System.out.println("Notification envoyée à " + dateEnvoi + " : " + contenu);
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public LocalDateTime getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDateTime dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    // Pour le débogage
    @Override
    public String toString() {
        return "[" + dateEnvoi + "] " + contenu;
    }
}
