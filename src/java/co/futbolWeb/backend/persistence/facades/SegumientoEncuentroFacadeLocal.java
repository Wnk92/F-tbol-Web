/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.SegumientoEncuentro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface SegumientoEncuentroFacadeLocal {

    void create(SegumientoEncuentro segumientoEncuentro);

    void edit(SegumientoEncuentro segumientoEncuentro);

    void remove(SegumientoEncuentro segumientoEncuentro);

    SegumientoEncuentro find(Object id);

    List<SegumientoEncuentro> findAll();

    List<SegumientoEncuentro> findRange(int[] range);

    int count();
    
}
