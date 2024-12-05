

package com.example.demo.service.interfaces;

import com.example.demo.persistance.entities.Rendezvous;
import java.util.List;

public interface IRendezvousService {
    boolean createRendezvous(Rendezvous rendezvous);

    List<Rendezvous> getAllRendezvous();

    Rendezvous getRendezvousById(Long id);

    Rendezvous updateRendezvous(Long id, Rendezvous rendezvous);

    Boolean deleteRendezvous(Long id);
}
