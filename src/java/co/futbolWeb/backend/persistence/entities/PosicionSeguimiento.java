/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "posicion_seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PosicionSeguimiento.findAll", query = "SELECT p FROM PosicionSeguimiento p"),
    @NamedQuery(name = "PosicionSeguimiento.findByFecha", query = "SELECT p FROM PosicionSeguimiento p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "PosicionSeguimiento.findByPosicion", query = "SELECT p FROM PosicionSeguimiento p WHERE p.posicion = :posicion")})
public class PosicionSeguimiento implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "posicion")
    private String posicion;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugador idJugador;
    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id_seguimiento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Seguimiento idSeguimiento;

    public PosicionSeguimiento() {
    }

    public PosicionSeguimiento(Date fecha) {
        this.fecha = fecha;
    }

    public PosicionSeguimiento(Date fecha, String posicion) {
        this.fecha = fecha;
        this.posicion = posicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public Seguimiento getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Seguimiento idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosicionSeguimiento)) {
            return false;
        }
        PosicionSeguimiento other = (PosicionSeguimiento) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.PosicionSeguimiento[ fecha=" + fecha + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return fecha.toString();
    }

}
