package com.example.gestionbiblio.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;
    
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevue;
    private boolean rendu = false;

    // Constructeurs
    public Emprunt() {}

    public Emprunt(Utilisateur utilisateur, Livre livre, LocalDate dateEmprunt, LocalDate dateRetourPrevue, boolean rendu) {
        this.utilisateur = utilisateur;
        this.livre = livre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.rendu = rendu;
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }

    public Livre getLivre() { return livre; }
    public void setLivre(Livre livre) { this.livre = livre; }

    public LocalDate getDateEmprunt() { return dateEmprunt; }
    public void setDateEmprunt(LocalDate dateEmprunt) { this.dateEmprunt = dateEmprunt; }

    public LocalDate getDateRetourPrevue() { return dateRetourPrevue; }
    public void setDateRetourPrevue(LocalDate dateRetourPrevue) { this.dateRetourPrevue = dateRetourPrevue; }

    public boolean isRendu() { return rendu; }
    public void setRendu(boolean rendu) { this.rendu = rendu; }
}
