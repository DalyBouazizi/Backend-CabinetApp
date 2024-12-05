
package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Medecin;
import com.example.demo.persistance.entities.Rendezvous;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {
    List<Rendezvous> findByMedecinAndDateRdvAndHeureRdv(Medecin medecin, Date dateRdv, Time heureRdv);
    List<Rendezvous> findByMedecinAndDateRdv(Medecin medecin, Date dateRdv);


}
