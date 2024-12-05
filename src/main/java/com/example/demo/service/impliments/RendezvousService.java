
package com.example.demo.service.impliments;

import com.example.demo.persistance.dao.RendezvousRepository;
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezvousService;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezvousService implements IRendezvousService {
    private final RendezvousRepository rendezvousRepository;

    @Autowired
    public RendezvousService(RendezvousRepository rendezvousRepository) {
        this.rendezvousRepository = rendezvousRepository;
    }

    private boolean isConflictingAppointment(Rendezvous rendezvous) {
        List<Rendezvous> conflictingAppointments = this.rendezvousRepository.findByMedecinAndDateRdv(rendezvous.getMedecin(), rendezvous.getDateRdv());

        for (Rendezvous existingRdv : conflictingAppointments) {
            // Check for time conflicts within a 30-minute buffer
            LocalTime newAppointmentTime = rendezvous.getHeureRdv().toLocalTime();
            LocalTime existingAppointmentTime = existingRdv.getHeureRdv().toLocalTime();

            // Calculate time difference in minutes
            long timeDifference = Math.abs(Duration.between(newAppointmentTime, existingAppointmentTime).toMinutes());

            if (timeDifference < 30) {
                return true; // Conflict found within 30 minutes
            }
        }
        return false; // No conflicts
    }

    public boolean createRendezvous(Rendezvous rendezvous) {
        if (this.isConflictingAppointment(rendezvous)) {

            return false;
        } else {
             this.rendezvousRepository.save(rendezvous);

             return true;
        }
    }

    public List<Rendezvous> getAllRendezvous() {
        return this.rendezvousRepository.findAll();
    }

    public Rendezvous getRendezvousById(Long id) {
        return (Rendezvous)this.rendezvousRepository.getReferenceById(id);
    }

    public Rendezvous updateRendezvous(Long id, Rendezvous updatedRendezvous) {
        Rendezvous existingRendezvous = (Rendezvous)this.rendezvousRepository.findById(id).orElseThrow(() -> new RuntimeException("Rendezvous with id " + id + " not found"));
        if (this.isConflictingAppointment(updatedRendezvous)) {
            throw new RuntimeException("Medecin already has an appointment at this time.");
        } else {
            existingRendezvous.setDateRdv(updatedRendezvous.getDateRdv());
            existingRendezvous.setHeureRdv(updatedRendezvous.getHeureRdv());
            existingRendezvous.setPatient(updatedRendezvous.getPatient());
            existingRendezvous.setMedecin(updatedRendezvous.getMedecin());
            existingRendezvous.setConsultation(updatedRendezvous.getConsultation());
            return (Rendezvous)this.rendezvousRepository.save(existingRendezvous);
        }
    }

    public Boolean deleteRendezvous(Long id) {
        this.rendezvousRepository.findById(id).orElseThrow(() -> new RuntimeException("Rendezvous with id " + id + " not found"));

        try {
            this.rendezvousRepository.deleteById(id);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }
}
