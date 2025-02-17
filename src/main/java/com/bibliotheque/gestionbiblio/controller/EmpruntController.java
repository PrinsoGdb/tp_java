package com.example.gestionbiblio.controller;

import com.example.gestionbiblio.entity.Emprunt;
import com.example.gestionbiblio.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emprunts")
public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;

    @GetMapping
    public String listEmprunts(Model model) {
        List<Emprunt> emprunts = empruntService.getAllEmprunts();
        model.addAttribute("emprunts", emprunts);
        return "emprunts";
    }

    @GetMapping("/{id}")
    public String getEmpruntById(@PathVariable Long id, Model model) {
        Optional<Emprunt> emprunt = empruntService.getEmpruntById(id);
        emprunt.ifPresent(value -> model.addAttribute("emprunt", value));
        return "emprunt-details";
    }

    @PostMapping("/add")
    public String addEmprunt(@ModelAttribute Emprunt emprunt) {
        empruntService.saveEmprunt(emprunt);
        return "redirect:/emprunts";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return "redirect:/emprunts";
    }
}
