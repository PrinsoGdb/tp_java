package com.bibliotheque.gestionbiblio.service;

import com.bibliotheque.gestionbiblio.entity.User;
import com.bibliotheque.gestionbiblio.repository.UserRepository;
import com.bibliotheque.gestionbiblio.entity.User;
import com.bibliotheque.gestionbiblio.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository utilisateurRepository;

    // Ajouter un utilisateur
    public User addUtilisateur(User utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Afficher tous les utilisateurs
    public List<User> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    // Afficher un utilisateur par ID
    public Optional<User> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    // Rechercher un utilisateur par nom ou email
    public List<User> searchUtilisateur(String keyword) {
        return utilisateurRepository.findByNomContainingOrEmailContaining(keyword, keyword);
    }

    // Mettre à jour un utilisateur
    @Transactional
    public User updateUtilisateur(Long id, User utilisateurDetails) {
        User utilisateur = utilisateurRepository.findById(id)
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
