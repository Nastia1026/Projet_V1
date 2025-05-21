package miniprojet.projet_v1.model;

import java.time.LocalTime;
import java.util.Objects;

public class Creneau {
    private String jour;
    private LocalTime heureDebut;
    private LocalTime heureFin;

    // Constructeurs
    public Creneau() {
    }

    public Creneau(String jour, LocalTime heureDebut, LocalTime heureFin) {
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    // Getters & Setters
    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    // Méthode de chevauchement
    public boolean chevauche(Creneau autre) {
        if (autre == null) return false;

        return this.jour.equalsIgnoreCase(autre.jour) &&
                this.heureDebut.isBefore(autre.heureFin) &&
                this.heureFin.isAfter(autre.heureDebut);
    }

    // Equals/HashCode pour comparaisons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creneau creneau = (Creneau) o;
        return Objects.equals(jour, creneau.jour) &&
                Objects.equals(heureDebut, creneau.heureDebut) &&
                Objects.equals(heureFin, creneau.heureFin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jour, heureDebut, heureFin);
    }

    // Pour l'affichage
    @Override
    public String toString() {
        return jour + " " + heureDebut + "-" + heureFin;
    }
}