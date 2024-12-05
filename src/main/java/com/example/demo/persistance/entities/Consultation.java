//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.persistance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long idCons;
    private Date dateCons;
    private String recapCons;
    @OneToOne
    @JoinColumn(
            name = "rdv_id",
            nullable = false
    )
    private Rendezvous rendezvous;

    public Consultation() {
    }

    public Long getIdCons() {
        return this.idCons;
    }

    public void setIdCons(Long idCons) {
        this.idCons = idCons;
    }

    public Date getDateCons() {
        return this.dateCons;
    }

    public void setDateCons(Date dateCons) {
        this.dateCons = dateCons;
    }

    public String getRecapCons() {
        return this.recapCons;
    }

    public void setRecapCons(String recapCons) {
        this.recapCons = recapCons;
    }

    public Rendezvous getRendezvous() {
        return this.rendezvous;
    }

    public void setRendezvous(Rendezvous rendezvous) {
        this.rendezvous = rendezvous;
    }
}
