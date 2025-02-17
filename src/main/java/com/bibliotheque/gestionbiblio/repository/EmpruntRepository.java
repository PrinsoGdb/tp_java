package com.example.gestionbiblio.repository;

import com.example.gestionbiblio.entity.Emprunt;
import com.example.gestionbiblio.entity.Utilisateur;
import com.example.gestionbiblio.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    List<Emprunt> findByUtilisateur(Utilisateur utilisateur);
    List<Emprunt> findByLivre(Livre livre);
}
