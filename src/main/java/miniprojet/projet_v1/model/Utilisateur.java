package miniprojet.projet_v1.model;

import java.util.List;

public abstract class Utilisateur {
    // Champs en protected pour l'héritage
    protected String id;
    protected String nom;
    protected String email;
    protected String motDePasse;

    // Méthodes abstraites
    public abstract boolean authentifier();
    public abstract List<Creneau> consulterEmploiDuTemps();

    // Getters/Setters (manuels sans Lombok)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
