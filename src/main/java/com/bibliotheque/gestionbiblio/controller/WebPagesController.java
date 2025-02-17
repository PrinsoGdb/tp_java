package com.example.gestionbiblio.controller;

import com.example.gestionbiblio.repositories.LivreRepository;
import com.example.gestionbiblio.repositories.EmpruntRepository;
import com.example.gestionbiblio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPagesController {
    @Autowired
    private LivreRepository livreRepository;

    @Autowired
    private EmpruntRepository empruntRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/livres")
    public String livres(Model model) {
        model.addAttribute("livres", livreRepository.findAll());
        return "livres";
    }

    @GetMapping("/livres/ajouter")
    public String ajouterLivre() {
        return "ajouterLivre";
    }

    @GetMapping("/livres/catalogue")
    public String catalogue(Model model) {
        model.addAttribute("livres", livreRepository.findAll());
        return "catalogue";
    }

    @GetMapping("/utilisateurs")
    public String utilisateurs(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "utilisateurs";
    }

    @GetMapping("/emprunts")
    public String emprunts(Model model) {
        model.addAttribute("emprunts", empruntRepository.findAll());
        return "emprunts";
    }
}
