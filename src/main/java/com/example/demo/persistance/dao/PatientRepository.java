//

package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNomPatient(String nomPatient);

    @Query(
            value = "select count(*) from patient",
            nativeQuery = true
    )
    int getQuantityOfPatient();

    @Query(
            value = "select * from patient where id= :id",
            nativeQuery = true
    )
    Patient getPatientByIdPatient(@Param("id") Long id);
}
