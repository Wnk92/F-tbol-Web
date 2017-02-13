/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.facades;

import co.futbolWeb.backend.persistence.entities.PosicionSeguimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camila
 */
@Stateless
public class PosicionSeguimientoFacade extends AbstractFacade<PosicionSeguimiento> implements PosicionSeguimientoFacadeLocal {

    @PersistenceContext(unitName = "WebFutbolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PosicionSeguimientoFacade() {
        super(PosicionSeguimiento.class);
    }
    
}
