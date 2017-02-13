/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.Equipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface EquipoFacadeLocal {

    void create(Equipo equipo);

    void edit(Equipo equipo);

    void remove(Equipo equipo);

    Equipo find(Object id);

    List<Equipo> findAll();

    List<Equipo> findRange(int[] range);

    int count();
    
}
