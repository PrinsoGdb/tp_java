package com.bibliotheque.gestionbiblio.repository;

import com.bibliotheque.gestionbiblio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Rechercher un utilisateur par nom ou email
    List<User> findByNomContainingOrEmailContaining(String nom, String email);
}