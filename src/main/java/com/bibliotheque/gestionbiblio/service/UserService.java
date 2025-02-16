package com.example.myapp.service;

import com.example.myapp.entity.User;
import com.example.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Ajouter un utilisateur
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Afficher tous les utilisateurs
    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    // Afficher un utilisateur par ID
    public Optional<User> showUser(Long id) {
        return userRepository.findById(id);
    }

    // Rechercher un utilisateur par nom ou email
    public List<User> searchUser(String keyword) {
        return userRepository.findByNomContainingOrEmailContaining(keyword, keyword);
    }

    // Mettre à jour un utilisateur
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        user.setNom(userDetails.getNom());
        user.setEmail(userDetails.getEmail());
        user.setTelephone(userDetails.getTelephone());
        return userRepository.save(user);
    }

    // Supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}