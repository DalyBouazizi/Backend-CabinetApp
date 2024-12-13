//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.persistance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.sql.Time;
import java.util.Date;

@Entity
public class Rendezvous {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long idRdv;
    private Date dateRdv;
    @JsonFormat(pattern = "HH:mm:ss") // Ensure the time format is matched
    private Time heureRdv;
    @ManyToOne
    @JoinColumn(
            name = "patient_id",
            nullable = false
    )
    @JsonIgnoreProperties("rendezvousList") // Ignore the 'rendezvousList' field in the Patient object
    private Patient patient;
    @ManyToOne
    @JoinColumn(
            name = "medecin_id",
            nullable = false
    )
    @JsonIgnoreProperties("rendezvousList") // Ignore the 'rendezvousList' field in the Patient object

    private Medecin medecin;
    @OneToOne(
            mappedBy = "rendezvous",
            cascade = {CascadeType.ALL}
    )
    private Consultation consultation;

    public Rendezvous() {
    }

    public Long getIdRdv() {
        return this.idRdv;
    }

    public void setIdRdv(Long idRdv) {
        this.idRdv = idRdv;
    }

    public Date getDateRdv() {
        return this.dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public Time getHeureRdv() {
        return this.heureRdv;
    }

    public void setHeureRdv(Time heureRdv) {
        this.heureRdv = heureRdv;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medecin getMedecin() {
        return this.medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Consultation getConsultation() {
        return this.consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
