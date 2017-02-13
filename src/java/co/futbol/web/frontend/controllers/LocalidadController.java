/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbol.web.frontend.controllers;

import co.futbolWeb.backend.persistence.entities.Localidad;
import co.futbolWeb.backend.persistence.facades.LocalidadFacadeLocal;
import co.futbolWeb.frontend.utilities.converter.InterfaceController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author camila
 */
@Named(value = "localidadController")
@ViewScoped
public class LocalidadController implements Serializable, InterfaceController<Localidad> {

    private Localidad localidad;
    @EJB
    private LocalidadFacadeLocal localidadfl;

    /**
     * Creates a new instance of LocalidadController
     */
    public LocalidadController() {
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @PostConstruct
    public void init() {

        localidad = new Localidad();

    }

    public void registrarLocalidad() {

        localidadfl.create(localidad);

    }

    @Override
    public Localidad getObjectByKey(Integer key) {
        return localidadfl.find(key);
    }
}
