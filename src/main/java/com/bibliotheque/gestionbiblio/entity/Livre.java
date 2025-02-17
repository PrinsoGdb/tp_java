package com.example.gestionbiblio.entity;

import jakarta.persistence.*;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private String genre;
    private int annee;
    private boolean disponible = true;

    // Constructeurs
    public Livre() {}

    public Livre(String titre, String auteur, String genre, int annee, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.annee = annee;
        this.disponible = disponible;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
