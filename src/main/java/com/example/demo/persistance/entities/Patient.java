
package com.example.demo.persistance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long idPatient;
    private String nomPatient;
    private String prenomPatient;
    private String adrPatient;
    private String emailPatient;
    @OneToMany(mappedBy = "patient", cascade = {CascadeType.ALL})
    @JsonIgnore
    private List<Rendezvous> rendezvousList;

    public Patient() {
    }

    public Long getIdPatient() {
        return this.idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomPatient() {
        return this.nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return this.prenomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    public String getAdrPatient() {
        return this.adrPatient;
    }

    public void setAdrPatient(String adrPatient) {
        this.adrPatient = adrPatient;
    }

    public String getEmailPatient() {
        return this.emailPatient;
    }

    public void setEmailPatient(String emailPatient) {
        this.emailPatient = emailPatient;
    }

    public List<Rendezvous> getRendezvousList() {
        return this.rendezvousList;
    }

    public void setRendezvousList(List<Rendezvous> rendezvousList) {
        this.rendezvousList = rendezvousList;
    }
}
