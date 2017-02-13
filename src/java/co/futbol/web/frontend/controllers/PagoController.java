/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbol.web.frontend.controllers;

import co.futbolWeb.backend.persistence.entities.Pago;
import co.futbolWeb.backend.persistence.facades.PagoFacadeLocal;
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
@Named(value = "pagoController")
@RequestScoped
public class PagoController implements Serializable, InterfaceController<Pago> {

    private Pago pago;
    @EJB
    private PagoFacadeLocal pagofl;

    public PagoController() {
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @PostConstruct
    public void init() {

        pago = new Pago();

    }

    public void registrarPago() {

        pagofl.create(pago);

    }

    public List<Pago> listarPago() {

        return pagofl.findAll();

    }

    @Override
    public Pago getObjectByKey(Integer key) {
        return pagofl.find(key);
    }

}
