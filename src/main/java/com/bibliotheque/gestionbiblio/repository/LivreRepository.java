package com.example.gestionbiblio.repository;

import com.example.gestionbiblio.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByDisponible(boolean disponible);
}
