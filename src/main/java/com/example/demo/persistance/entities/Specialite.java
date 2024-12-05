//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Specialite {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long idspec;
    private String nomSpecialite;
    @OneToMany(
            mappedBy = "specialite",
            cascade = {CascadeType.ALL}
    )
    @JsonIgnoreProperties({"specialite"})
    private List<Medecin> medecins;

    public Specialite() {
    }

    public Long getIdspec() {
        return this.idspec;
    }

    public void setIdspec(Long idspec) {
        this.idspec = idspec;
    }

    public String getNomSpecialite() {
        return this.nomSpecialite;
    }

    public void setNomSpecialite(String nomSpecialite) {
        this.nomSpecialite = nomSpecialite;
    }

    public List<Medecin> getMedecins() {
        return this.medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }
}
