/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.PosicionSeguimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface PosicionSeguimientoFacadeLocal {

    void create(PosicionSeguimiento posicionSeguimiento);

    void edit(PosicionSeguimiento posicionSeguimiento);

    void remove(PosicionSeguimiento posicionSeguimiento);

    PosicionSeguimiento find(Object id);

    List<PosicionSeguimiento> findAll();

    List<PosicionSeguimiento> findRange(int[] range);

    int count();
    
}
