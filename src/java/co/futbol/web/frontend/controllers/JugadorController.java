/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbol.web.frontend.controllers;

import co.futbolWeb.backend.persistence.entities.Jugador;
import co.futbolWeb.backend.persistence.facades.JugadorFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author camila
 */
@Named(value = "jugadorController")
@RequestScoped
public class JugadorController {

  
    private Jugador jugador;
    @EJB
    private JugadorFacadeLocal jugadorfl;
    
    
    public JugadorController() {
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public void init(){
    
    jugador = new Jugador();
    
    }
    
    public void registrarJugador(){
    
        jugadorfl.create(jugador);
        
    }
    
    public List<Jugador> listarJugador(){
    return jugadorfl.findAll();
    }
    
    
}
