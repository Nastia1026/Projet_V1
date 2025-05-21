package miniprojet.projet_v1.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Administrateur extends Utilisateur {

    // Constructeurs
    public Administrateur() {
    }

    public Administrateur(String id, String nom, String email) {
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
        return new ArrayList<>();
    }

    // Méthodes spécifiques
    public Cours creerCours(String nom, Matiere matiere, List<Creneau> creneaux, Salle salle) {
        Cours cours = new Cours();
        cours.setNom(nom);
        cours.setMatiere(matiere);
        cours.setCreneaux(creneaux);
        cours.setSalle(salle);
        cours.setId("COURS-" + System.currentTimeMillis());
        return cours;
    }

    public void modifierEmploiDuTemps(Cours cours, Creneau nouveauCreneau) {
        if (cours != null && nouveauCreneau != null) {
            cours.getCreneaux().clear();
            cours.ajouterCreneau(nouveauCreneau);
        }
    }

    public void affecterEnseignant(Cours cours, Enseignant enseignant) {
        if (cours != null && enseignant != null) {
            cours.setEnseignant(enseignant);
        }
    }

    public Map<String, Integer> genererStatistiques() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Créneaux utilisés", 42);
        stats.put("Salles occupées", 15);
        stats.put("Heures enseignées", 120);
        return stats;
    }
}