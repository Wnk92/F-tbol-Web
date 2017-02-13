/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.HorarioClub;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface HorarioClubFacadeLocal {

    void create(HorarioClub horarioClub);

    void edit(HorarioClub horarioClub);

    void remove(HorarioClub horarioClub);

    HorarioClub find(Object id);

    List<HorarioClub> findAll();

    List<HorarioClub> findRange(int[] range);

    int count();
    
}
