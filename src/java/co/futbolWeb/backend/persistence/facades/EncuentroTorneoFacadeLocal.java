/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.EncuentroTorneo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface EncuentroTorneoFacadeLocal {

    void create(EncuentroTorneo encuentroTorneo);

    void edit(EncuentroTorneo encuentroTorneo);

    void remove(EncuentroTorneo encuentroTorneo);

    EncuentroTorneo find(Object id);

    List<EncuentroTorneo> findAll();

    List<EncuentroTorneo> findRange(int[] range);

    int count();
    
}
