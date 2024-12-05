
package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Medecin;
import com.example.demo.service.impliments.MedecinService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/medecin"})
public class MedecinController {
    private MedecinService medecinService;

    public MedecinController(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @PostMapping({"/create"})
    public boolean CreateMedecin(@RequestBody Medecin medecin) {
        Medecin Responsemedecin = this.medecinService.createMedecin(medecin);
        return Responsemedecin != null;
    }

    @GetMapping({"/GetAllMed"})
    public List<Medecin> getAllMedecin() {
        List<Medecin> MedecinsList = this.medecinService.getAllMedecins();
        return MedecinsList;
    }

    @DeleteMapping({"/delete/{id}"})
    public String DeleteMedecin(@PathVariable Long id) {
        boolean bool = this.medecinService.deleteMedecin(id);
        return bool ? "Deleted Successfully" : "Deleted Failed";
    }

    @PutMapping({"/update/{id}"})
    public ResponseEntity<String> UpdateMedecin(@PathVariable Long id, @RequestBody Medecin medecin) {
        this.medecinService.updateMedecin(id, medecin);
        return ResponseEntity.ok("Updated Successfuly");
    }
}
