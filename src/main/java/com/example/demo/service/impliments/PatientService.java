
package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.PatientRepository;
import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements IPatient {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return (Patient)this.patientRepository.save(patient);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Optional<Patient> existingPatient = this.patientRepository.findById(id);
        if (existingPatient.isPresent()) {
            Patient patient = (Patient)existingPatient.get();
            patient.setNomPatient(updatedPatient.getNomPatient());
            patient.setPrenomPatient(updatedPatient.getPrenomPatient());
            patient.setAdrPatient(updatedPatient.getAdrPatient());
            patient.setEmailPatient(updatedPatient.getEmailPatient());
            return (Patient)this.patientRepository.save(patient);
        } else {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }

    public void deletePatient(Long id) {
        this.patientRepository.deleteById(id);
    }

    public Patient getPatientById(Long id) {
        return (Patient)this.patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    public List<Patient> getAllPatients() {
        return this.patientRepository.findAll();
    }
}
