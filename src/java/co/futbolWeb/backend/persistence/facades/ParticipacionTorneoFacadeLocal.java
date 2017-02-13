/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.ParticipacionTorneo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface ParticipacionTorneoFacadeLocal {

    void create(ParticipacionTorneo participacionTorneo);

    void edit(ParticipacionTorneo participacionTorneo);

    void remove(ParticipacionTorneo participacionTorneo);

    ParticipacionTorneo find(Object id);

    List<ParticipacionTorneo> findAll();

    List<ParticipacionTorneo> findRange(int[] range);

    int count();
    
}
