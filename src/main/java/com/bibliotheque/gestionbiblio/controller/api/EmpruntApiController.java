package com.example.gestionbiblio.controller.api;

import com.example.gestionbiblio.entity.Emprunt;
import com.example.gestionbiblio.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprunts")
@CrossOrigin(origins = "*")
public class EmpruntApiController {
    
    @Autowired
    private EmpruntService empruntService;

    @GetMapping
    public ResponseEntity<List<Emprunt>> getAllEmprunts() {
        return ResponseEntity.ok(empruntService.getAllEmprunts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprunt> getEmpruntById(@PathVariable Long id) {
        Optional<Emprunt> emprunt = empruntService.getEmpruntById(id);
        return emprunt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Emprunt> addEmprunt(@RequestBody Emprunt emprunt) {
        return ResponseEntity.ok(empruntService.saveEmprunt(emprunt));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprunt> updateEmprunt(@PathVariable Long id, @RequestBody Emprunt emprunt) {
        return ResponseEntity.ok(empruntService.updateEmprunt(id, emprunt));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprunt(@PathVariable Long id) {
        empruntService.deleteEmprunt(id);
        return ResponseEntity.ok().build();
    }
}
