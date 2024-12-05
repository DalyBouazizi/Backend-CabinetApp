//

package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Consultation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    @Query("SELECT c FROM Consultation c WHERE c.rendezvous.idRdv = :idRdv")
    List<Consultation> findByRendezvous(@Param("idRdv") Long idRdv);

    @Query("SELECT c FROM Consultation c WHERE c.rendezvous.patient.idPatient = :idPatient")
    List<Consultation> findByPatient(@Param("idPatient") Long idPatient);
}
