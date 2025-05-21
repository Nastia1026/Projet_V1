package miniprojet.projet_v1.model;

import java.util.ArrayList;
import java.util.List;

public class Cours {
    private String id;
    private String nom;
    private Matiere matiere;
    private List<Creneau> creneaux = new ArrayList<>();
    private Salle salle;
    private Enseignant enseignant;

    // Constructeurs
    public Cours() {
    }

    public Cours(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters & Setters
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

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public List<Creneau> getCreneaux() {
        return creneaux;
    }

    public void setCreneaux(List<Creneau> creneaux) {
        this.creneaux = creneaux;
    }

    // Méthodes métier
    public void ajouterCreneau(Creneau creneau) {
        if (creneau != null && !creneaux.contains(creneau)) {
            creneaux.add(creneau);
        }
    }

    public void supprimerCreneau(Creneau creneau) {
        if (creneau != null) {
            creneaux.remove(creneau);
        }
    }
}
