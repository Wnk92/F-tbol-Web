/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.ActividadElectiva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface ActividadElectivaFacadeLocal {

    void create(ActividadElectiva actividadElectiva);

    void edit(ActividadElectiva actividadElectiva);

    void remove(ActividadElectiva actividadElectiva);

    ActividadElectiva find(Object id);

    List<ActividadElectiva> findAll();

    List<ActividadElectiva> findRange(int[] range);

    int count();
    
}
