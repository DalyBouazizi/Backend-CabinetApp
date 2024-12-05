
package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Medecin;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);

    @Query("SELECT m FROM Medecin m WHERE m.specialite.idspec = :idspec")
    List<Medecin> findBySpecialite(@Param("idspec") Long idspec);
}
