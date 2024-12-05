//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.SpecialiteRepository;
import com.example.demo.persistance.entities.Specialite;
import com.example.demo.service.interfaces.ISpecialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialiteService implements ISpecialite {
    private SpecialiteRepository specialiteRepository;

    @Autowired
    public SpecialiteService(SpecialiteRepository specialiteRepository) {
        this.specialiteRepository = specialiteRepository;
    }

    public Specialite getSpecialiteById(Long id) {
        return (Specialite)this.specialiteRepository.findById(id).orElseThrow(() -> new RuntimeException("Specialite with id " + id + " not found"));
    }
}
