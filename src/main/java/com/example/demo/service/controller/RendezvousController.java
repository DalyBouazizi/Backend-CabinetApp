
package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Patient;
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.impliments.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/rendezvous"})
public class RendezvousController {
    private final RendezvousService rendezvousService;

    @Autowired
    public RendezvousController(RendezvousService rendezvousService) {
        this.rendezvousService = rendezvousService;
    }

    @PostMapping
    public ResponseEntity<String> createRendezvous(@RequestBody Rendezvous rendezvous) {
        boolean test = false;  // Declare test outside of the try block
        try {
            test = this.rendezvousService.createRendezvous(rendezvous);  // Assign the result of the service call
        } catch (RuntimeException var3) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error occurred");
        }

        // Now you can safely check the value of 'test'
        if (test) {
            return ResponseEntity.ok("Successfully created");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Medecin already has an appointment at this time.");
        }
    }


    @GetMapping({"/{id}"})
    public ResponseEntity<Rendezvous> getRDVById(@PathVariable Long id) {
        Rendezvous rendezvous = this.rendezvousService.getRendezvousById(id);
        return ResponseEntity.ok(rendezvous);
    }

    @GetMapping
    public ResponseEntity<List<Rendezvous>> getAllRDVS() {
        List<Rendezvous> rendezvous = this.rendezvousService.getAllRendezvous();
        return ResponseEntity.ok(rendezvous);
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<String> updateRendezvous(@PathVariable Long id, @RequestBody Rendezvous updatedRendezvous) {
        try {
            Rendezvous updatedRdv = this.rendezvousService.updateRendezvous(id, updatedRendezvous);
            return ResponseEntity.ok("Updated successfully");
        } catch (RuntimeException var4) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("failed to update");
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteRendezvous(@PathVariable Long id) {
        this.rendezvousService.deleteRendezvous(id);
        return ResponseEntity.noContent().build();
    }
}
