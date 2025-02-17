package com.example.gestionbiblio.service;

import com.example.gestionbiblio.entity.Utilisateur;
import com.example.gestionbiblio.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Ajouter un utilisateur
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Afficher tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Afficher un utilisateur par ID
    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    // Rechercher un utilisateur par nom ou email
    public List<Utilisateur> searchUtilisateur(String keyword) {
        return utilisateurRepository.findByNomContainingOrEmailContaining(keyword, keyword);
    }

    // Mettre à jour un utilisateur
    @Transactional
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur avec ID " + id + " non trouvé"));
        utilisateur.setNom(utilisateurDetails.getNom());
        utilisateur.setEmail(utilisateurDetails.getEmail());
        utilisateur.setTelephone(utilisateurDetails.getTelephone());
        return utilisateurRepository.save(utilisateur);
    }

    // Supprimer un utilisateur
    public void deleteUtilisateur(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new IllegalArgumentException("Utilisateur avec ID " + id + " non trouvé");
        }
        utilisateurRepository.deleteById(id);
    }
}
