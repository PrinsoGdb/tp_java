package com.example.gestionbiblio.controller.api;

import com.example.gestionbiblio.entity.Livre;
import com.example.gestionbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livres")
@CrossOrigin(origins = "*")
public class LivreApiController {
    
    @Autowired
    private LivreService livreService;

    @GetMapping
    public ResponseEntity<List<Livre>> getAllLivres() {
        return ResponseEntity.ok(livreService.getAllLivres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        Optional<Livre> livre = livreService.getLivreById(id);
        return livre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livre> addLivre(@RequestBody Livre livre) {
        return ResponseEntity.ok(livreService.saveLivre(livre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        return ResponseEntity.ok(livreService.updateLivre(id, livre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        Optional<Livre> livre = livreService.getLivreById(id);
        if (livre.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        livreService.deleteLivre(id);
        return ResponseEntity.ok().build();
    }
}
