package com.example.gestionbiblio.controller;

import com.example.gestionbiblio.entity.User;
import com.example.gestionbiblio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Permet les requêtes frontend
public class UserController {

    @Autowired
    private UserService userService;

    // Ajouter un utilisateur
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Récupérer tous les utilisateurs
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.showAllUsers();
        return ResponseEntity.ok(users);
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.showUser(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Rechercher un utilisateur par nom ou email
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam String keyword) {
        List<User> users = userService.searchUser(keyword);
        return ResponseEntity.ok(users);
    }

    // Mettre à jour un utilisateur
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Supprimer un utilisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
