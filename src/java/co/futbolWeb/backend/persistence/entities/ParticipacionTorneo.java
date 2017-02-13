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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "participaciones_torneo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParticipacionTorneo.findAll", query = "SELECT p FROM ParticipacionTorneo p"),
    @NamedQuery(name = "ParticipacionTorneo.findByIdParticipacionesTorneo", query = "SELECT p FROM ParticipacionTorneo p WHERE p.idParticipacionesTorneo = :idParticipacionesTorneo")})
public class ParticipacionTorneo implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_participaciones_torneo")
    private Integer idParticipacionesTorneo;
    @JoinColumn(name = "id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo idEquipo;
    @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Torneo idTorneo;

    public ParticipacionTorneo() {
    }

    public ParticipacionTorneo(Integer idParticipacionesTorneo) {
        this.idParticipacionesTorneo = idParticipacionesTorneo;
    }

    public Integer getIdParticipacionesTorneo() {
        return idParticipacionesTorneo;
    }

    public void setIdParticipacionesTorneo(Integer idParticipacionesTorneo) {
        this.idParticipacionesTorneo = idParticipacionesTorneo;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipacionesTorneo != null ? idParticipacionesTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipacionTorneo)) {
            return false;
        }
        ParticipacionTorneo other = (ParticipacionTorneo) object;
        if ((this.idParticipacionesTorneo == null && other.idParticipacionesTorneo != null) || (this.idParticipacionesTorneo != null && !this.idParticipacionesTorneo.equals(other.idParticipacionesTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.ParticipacionTorneo[ idParticipacionesTorneo=" + idParticipacionesTorneo + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idParticipacionesTorneo.toString();
    }

}
