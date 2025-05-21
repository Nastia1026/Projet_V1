package miniprojet.projet_v1.model;

import miniprojet.projet_v1.model.*;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Création d'un administrateur
        Administrateur admin = new Administrateur("ADM-001", "Marie Dupont", "admin@ecole.fr");
        admin.setMotDePasse("secure123");

        System.out.println("=== TEST AUTHENTIFICATION ADMIN ===");
        System.out.println("Admin authentifié : " + admin.authentifier() + "\n");

        // 2. Création d'une matière
        Matiere java = new Matiere("PROG101", "Programmation Java", 4);

        // 3. Création d'une salle
        Salle salleInfo = new Salle("B205", 30);
        salleInfo.getEquipements().addAll(List.of("Projecteur", "Ordinateurs"));

        // 4. Création de créneaux horaires
        Creneau creneau1 = new Creneau("Lundi", LocalTime.of(14, 0), LocalTime.of(16, 0));
        Creneau creneau2 = new Creneau("Jeudi", LocalTime.of(10, 30), LocalTime.of(12, 30));

        // 5. Création d'un cours par l'admin
        Cours coursJava = admin.creerCours(
                "POO en Java",
                java,
                List.of(creneau1, creneau2),
                salleInfo
        );

        System.out.println("=== COURS CREE ===");
        System.out.println(coursJava.getNom() + " - " + coursJava.getMatiere().getNom());
        System.out.println("Salle : " + coursJava.getSalle().getNumero());
        System.out.println("Créneaux : " + coursJava.getCreneaux() + "\n");

        // 6. Création d'un enseignant
        Enseignant profSmith = new Enseignant("ENS-456", "John Smith", "john.smith@ecole.fr");
        profSmith.setMotDePasse("java4ever");
        profSmith.getMatieresEnseignees().add(java);

        // 7. Affectation de l'enseignant au cours
        admin.affecterEnseignant(coursJava, profSmith);

        System.out.println("=== ENSEIGNANT AFFECTE ===");
        System.out.println("Enseignant du cours : " + coursJava.getEnseignant().getNom() + "\n");

        // 8. Création d'un étudiant
        Etudiant etudiant = new Etudiant("ETU-789", "Alice Martin", "alice.martin@ecole.fr");
        etudiant.setNumeroEtudiant("MARTIN2023");
        etudiant.setGroupe("Groupe A");

        // 9. Envoi de notification
        Notification notif = new Notification("NOTIF-001", "Nouveau cours ajouté : POO en Java");
        notif.envoyer();
        etudiant.recevoirNotification(notif);

        System.out.println("=== NOTIFICATIONS ETUDIANT ===");
        System.out.println("Nombre de notifications : " + etudiant.getNotifications().size());
        System.out.println("Dernière notification : " + etudiant.getNotifications().get(0) + "\n");

        // 10. Test de disponibilité de salle
        Creneau testCreneau = new Creneau("Lundi", LocalTime.of(15, 30), LocalTime.of(17, 0));
        System.out.println("=== TEST DISPONIBILITE SALLE ===");
        System.out.println("Disponible pour " + testCreneau + " : " + salleInfo.estDisponible(testCreneau));
    }
}