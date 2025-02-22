package com.bibliotheque.gestionbiblio.service;

import com.bibliotheque.gestionbiblio.repository.EmpruntRepository;
import com.bibliotheque.gestionbiblio.entity;
import com.example.gestionbiblio.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpruntService {
    @Autowired
    private EmpruntRepository empruntRepository;

    public List<Emprunt> getAllEmprunts() {
        return empruntRepository.findAll();
    }

    public Optional<Emprunt> getEmpruntById(Long id) {
        return empruntRepository.findById(id);
    }

    public Emprunt saveEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public void deleteEmprunt(Long id) {
        empruntRepository.deleteById(id);
    }
}
