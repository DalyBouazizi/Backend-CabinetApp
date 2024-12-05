
package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.MedecinRepository;
import com.example.demo.persistance.dao.SpecialiteRepository;
import com.example.demo.persistance.entities.Medecin;
import com.example.demo.persistance.entities.Specialite;
import com.example.demo.service.interfaces.IMedecin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedecinService implements IMedecin {
    private MedecinRepository medecinRepository;
    private SpecialiteRepository specialiteRepository;

    @Autowired
    public MedecinService(MedecinRepository medecinRepository, SpecialiteRepository specialiteRepository) {
        this.medecinRepository = medecinRepository;
        this.specialiteRepository = specialiteRepository;
    }

    public Medecin createMedecin(Medecin medecin) {
        return (Medecin)this.medecinRepository.save(medecin);
    }

    public Medecin updateMedecin(Long id, Medecin UpdatedMedecin) {
        Medecin existingMedecin = (Medecin)this.medecinRepository.findById(id).orElseThrow(() -> new RuntimeException("Medecin with id " + id + " not found"));
        existingMedecin.setNom(UpdatedMedecin.getNom());
        existingMedecin.setPrenom(UpdatedMedecin.getPrenom());
        existingMedecin.setAdr(UpdatedMedecin.getAdr());
        existingMedecin.setEmail(UpdatedMedecin.getEmail());
        if (UpdatedMedecin.getSpecialite() != null && UpdatedMedecin.getSpecialite().getIdspec() != null) {
            Specialite specialite = (Specialite)this.specialiteRepository.findById(UpdatedMedecin.getSpecialite().getIdspec()).orElseThrow(() -> new RuntimeException("Specialite with id " + UpdatedMedecin.getSpecialite().getIdspec() + " not found"));
            existingMedecin.setSpecialite(specialite);
        }

        return (Medecin)this.medecinRepository.save(existingMedecin);
    }

    public boolean deleteMedecin(Long id) {
        if (this.medecinRepository.existsById(id)) {
            this.medecinRepository.deleteById(id);
            return !this.medecinRepository.existsById(id);
        } else {
            return false;
        }
    }

    public Medecin getMedecinById(Long id) {
        return null;
    }

    public List<Medecin> getAllMedecins() {
        return this.medecinRepository.findAll();
    }
}
