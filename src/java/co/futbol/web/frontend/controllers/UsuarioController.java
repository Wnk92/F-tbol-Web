/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbol.web.frontend.controllers;

import co.futbolWeb.backend.persistence.entities.Usuario;
import co.futbolWeb.backend.persistence.facades.UsuarioFacadeLocal;
import co.futbolWeb.frontend.utilities.converter.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author camila
 */
@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable, InterfaceController<Usuario> {

    private Usuario usuario;
    @EJB
    private UsuarioFacadeLocal usuariofl;

    public UsuarioController() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void init() {

        usuario = new Usuario();

    }

    public void regitrarUsuario() {
        usuariofl.create(usuario);
    }

    public List<Usuario> listarUsuario() {

        return usuariofl.findAll();
    }

    @Override
    public Usuario getObjectByKey(Integer key) {
        return usuariofl.find(key);
    }

}
