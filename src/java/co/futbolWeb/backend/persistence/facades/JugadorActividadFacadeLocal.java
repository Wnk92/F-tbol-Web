/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.JugadorActividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface JugadorActividadFacadeLocal {

    void create(JugadorActividad jugadorActividad);

    void edit(JugadorActividad jugadorActividad);

    void remove(JugadorActividad jugadorActividad);

    JugadorActividad find(Object id);

    List<JugadorActividad> findAll();

    List<JugadorActividad> findRange(int[] range);

    int count();
    
}
