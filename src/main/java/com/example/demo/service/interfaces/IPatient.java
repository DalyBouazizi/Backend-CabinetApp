
package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Patient;
import java.util.List;

public interface IPatient {
    Patient createPatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);

    Patient getPatientById(Long id);

    List<Patient> getAllPatients();
}
