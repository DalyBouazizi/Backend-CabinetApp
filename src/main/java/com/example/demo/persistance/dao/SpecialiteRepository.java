
package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
    Specialite findByNomSpecialite(String nomSpecialite);
}
