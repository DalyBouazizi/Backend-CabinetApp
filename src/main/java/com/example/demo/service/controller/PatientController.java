

package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping({"/api/patients"})
public class PatientController {
    private final IPatient patientService;

    @Autowired
    public PatientController(IPatient patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = this.patientService.createPatient(patient);
        return ResponseEntity.ok(createdPatient);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient updatedPatient = this.patientService.updatePatient(id, patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        this.patientService.deletePatient(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = this.patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = this.patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }
}
