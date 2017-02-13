/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.Desempeño;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface DesempeñoFacadeLocal {

    void create(Desempeño desempeño);

    void edit(Desempeño desempeño);

    void remove(Desempeño desempeño);

    Desempeño find(Object id);

    List<Desempeño> findAll();

    List<Desempeño> findRange(int[] range);

    int count();
    
}
