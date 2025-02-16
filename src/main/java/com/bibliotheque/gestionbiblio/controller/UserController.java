package com.example.myapp.controller;

import com.example.myapp.entity.User;
import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Permettre les requêtes frontend
public class UserController {

    @Autowired
    private UserService userService;

    // Ajouter un utilisateur
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Récupérer tous les utilisateurs
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.showAllUsers();
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.showUser(id);
    }

    // Rechercher un utilisateur par nom ou email
    @GetMapping("/search")
    public List<User> searchUser(@RequestParam String keyword) {
        return userService.searchUser(keyword);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
