/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbol.web.frontend.controllers;

import co.futbolWeb.backend.persistence.entities.Ciudad;
import co.futbolWeb.backend.persistence.facades.CiudadFacadeLocal;
import co.futbolWeb.frontend.utilities.converter.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "ciudadController")
@RequestScoped
public class CiudadController implements Serializable, InterfaceController<Ciudad> {
    
    private Ciudad ciudad;
    @EJB
    private CiudadFacadeLocal ciudadfl;
    
    public CiudadController() {
    }
    
    public Ciudad getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    @PostConstruct
    public void init() {
        
        ciudad = new Ciudad();
        
    }
    
    public void registrarCiudad() {
        
        ciudadfl.create(ciudad);
        
    }
    
    public List<Ciudad> listarCiudad() {
        
        return ciudadfl.findAll();
        
    }
    
    @Override
    public Ciudad getObjectByKey(Integer key) {
        return ciudadfl.find(key);
    }
    
}
