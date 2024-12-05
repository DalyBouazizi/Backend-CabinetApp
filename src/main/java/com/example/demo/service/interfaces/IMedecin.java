
package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Medecin;
import java.util.List;

public interface IMedecin {
    Medecin createMedecin(Medecin medecin);

    Medecin updateMedecin(Long id, Medecin medecin);

    boolean deleteMedecin(Long id);

    Medecin getMedecinById(Long id);

    List<Medecin> getAllMedecins();
}
