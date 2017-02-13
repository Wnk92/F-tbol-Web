/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "jugadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByIdJugador", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugador.findByPosicion", query = "SELECT j FROM Jugador j WHERE j.posicion = :posicion")})
public class Jugador implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_jugador")
    private Integer idJugador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "posicion")
    private String posicion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<JugadorActividad> jugadorActividadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuarioJugador", fetch = FetchType.EAGER)
    private List<Seguimiento> seguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.EAGER)
    private List<SegumientoEncuentro> segumientoEncuentroList;
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo fkIdEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdJugador", fetch = FetchType.EAGER)
    private List<Pago> pagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.EAGER)
    private List<PosicionSeguimiento> posicionSeguimientoList;

    public Jugador() {
    }

    public Jugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(Integer idJugador, String posicion) {
        this.idJugador = idJugador;
        this.posicion = posicion;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @XmlTransient
    public List<JugadorActividad> getJugadorActividadList() {
        return jugadorActividadList;
    }

    public void setJugadorActividadList(List<JugadorActividad> jugadorActividadList) {
        this.jugadorActividadList = jugadorActividadList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<SegumientoEncuentro> getSegumientoEncuentroList() {
        return segumientoEncuentroList;
    }

    public void setSegumientoEncuentroList(List<SegumientoEncuentro> segumientoEncuentroList) {
        this.segumientoEncuentroList = segumientoEncuentroList;
    }

    public Equipo getFkIdEquipo() {
        return fkIdEquipo;
    }

    public void setFkIdEquipo(Equipo fkIdEquipo) {
        this.fkIdEquipo = fkIdEquipo;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @XmlTransient
    public List<PosicionSeguimiento> getPosicionSeguimientoList() {
        return posicionSeguimientoList;
    }

    public void setPosicionSeguimientoList(List<PosicionSeguimiento> posicionSeguimientoList) {
        this.posicionSeguimientoList = posicionSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idJugador == null && other.idJugador != null) || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.Jugador[ idJugador=" + idJugador + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idJugador.toString();
    }

}
