package miniprojet.projet_v1.model;

import java.util.Objects;

public class Matiere {
    // Attributs de l'UML
    private String code;
    private String nom;
    private int credits;

    // Constructeurs
    public Matiere() {
    }

    public Matiere(String code, String nom, int credits) {
        this.code = code;
        this.nom = nom;
        this.setCredits(credits); // Utilisation du setter pour la validation
    }

    // Getters & Setters avec validation
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits < 0) {
            throw new IllegalArgumentException("Les crédits ne peuvent pas être négatifs");
        }
        this.credits = credits;
    }

    // Equals/HashCode/ToString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matiere matiere = (Matiere) o;
        return credits == matiere.credits &&
                Objects.equals(code, matiere.code) &&
                Objects.equals(nom, matiere.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, nom, credits);
    }

    @Override
    public String toString() {
        return code + " - " + nom + " (" + credits + "crédits)";
    }
}