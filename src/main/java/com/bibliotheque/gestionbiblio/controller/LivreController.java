package com.example.gestionbiblio.controller;

import com.example.gestionbiblio.entity.Livre;
import com.example.gestionbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping
    public String listLivres(Model model) {
        List<Livre> livres = livreService.getAllLivres();
        model.addAttribute("livres", livres);
        return "livres";
    }

    @GetMapping("/{id}")
    public String getLivreById(@PathVariable Long id, Model model) {
        Optional<Livre> livre = livreService.getLivreById(id);
        livre.ifPresent(value -> model.addAttribute("livre", value));
        return "livre-details";
    }

    @PostMapping("/add")
    public String addLivre(@ModelAttribute Livre livre) {
        livreService.saveLivre(livre);
        return "redirect:/livres";
    }

    @PostMapping("/delete/{id}")
    public String deleteLivre(@PathVariable Long id) {
        livreService.deleteLivre(id);
        return "redirect:/livres";
    }
}
