package miniprojet.projet_v1.model;

import miniprojet.projet_v1.model.Administrateur;
import miniprojet.projet_v1.model.Enseignant;
import miniprojet.projet_v1.model.Etudiant;
import miniprojet.projet_v1.model.Utilisateur;

public class AuthService {

    // Méthode d'authentification basée sur vos classes
    public Utilisateur authenticate(String email, String password) {
        if ("admin@ecole.fr".equals(email) && "admin123".equals(password)) {
            Administrateur admin = new Administrateur();
            admin.setId("ADM-001");
            admin.setEmail(email);
            admin.setMotDePasse(password);
            return admin;
        }

        if ("enseignant@ecole.fr".equalsIgnoreCase(email) && "prof123".equals(password)) {
            Enseignant enseignant = new Enseignant();
            enseignant.setId("ENS-002");
            enseignant.setEmail(email);
            enseignant.setMotDePasse(password);
            return enseignant;
        }

        if ("etudiant@ecole.fr".equalsIgnoreCase(email) && "etu123".equals(password)) {
            Etudiant etudiant = new Etudiant();
            etudiant.setId("ETU-003");
            etudiant.setEmail(email);
            etudiant.setMotDePasse(password);
            return etudiant;
        }

        return null;
    }
}