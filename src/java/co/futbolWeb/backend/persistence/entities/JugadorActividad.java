/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "jugadores_actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JugadorActividad.findAll", query = "SELECT j FROM JugadorActividad j"),
    @NamedQuery(name = "JugadorActividad.findByIdActividad", query = "SELECT j FROM JugadorActividad j WHERE j.idActividad = :idActividad")})
public class JugadorActividad implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_actividad")
    private Integer idActividad;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugador fkIdUsuario;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private ActividadElectiva actividadElectiva;

    public JugadorActividad() {
    }

    public JugadorActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public Jugador getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Jugador fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public ActividadElectiva getActividadElectiva() {
        return actividadElectiva;
    }

    public void setActividadElectiva(ActividadElectiva actividadElectiva) {
        this.actividadElectiva = actividadElectiva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadorActividad)) {
            return false;
        }
        JugadorActividad other = (JugadorActividad) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.JugadorActividad[ idActividad=" + idActividad + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idActividad.toString();
    }

}
