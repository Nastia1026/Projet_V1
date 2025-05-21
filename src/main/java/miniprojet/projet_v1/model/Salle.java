package miniprojet.projet_v1.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    // Attributs UML
    private String numero;
    private int capacite;
    private List<String> equipements = new ArrayList<>();

    // Attribut supplémentaire pour gérer les réservations
    private List<Creneau> creneauxReserves = new ArrayList<>();

    // Constructeurs
    public Salle() {
    }

    public Salle(String numero, int capacite) {
        this.numero = numero;
        this.setCapacite(capacite);
    }

    // Méthode de disponibilité (logique complète)
    public boolean estDisponible(Creneau creneau) {
        if (creneau == null) return false;

        return creneauxReserves.stream()
                .noneMatch(c -> c.chevauche(creneau));
    }

    // Méthode utilitaire pour réserver un créneau
    public void reserverCreneau(Creneau creneau) {
        if (creneau != null && estDisponible(creneau)) {
            creneauxReserves.add(creneau);
        }
    }

    // Getters & Setters avec validation
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        if (capacite < 0) {
            throw new IllegalArgumentException("Capacité négative impossible");
        }
        this.capacite = capacite;
    }

    public List<String> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<String> equipements) {
        this.equipements = equipements;
    }

    // Pour l'affichage
    @Override
    public String toString() {
        return "Salle " + numero + " (" + capacite + " places)";
    }
}
