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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "seguimientos_encuentros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegumientoEncuentro.findAll", query = "SELECT s FROM SegumientoEncuentro s"),
    @NamedQuery(name = "SegumientoEncuentro.findByIdseguimientoEncuentro", query = "SELECT s FROM SegumientoEncuentro s WHERE s.idseguimientoEncuentro = :idseguimientoEncuentro")})
public class SegumientoEncuentro implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_seguimientoEncuentro")
    private Integer idseguimientoEncuentro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_encuentro", referencedColumnName = "id_encuentro")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EncuentroTorneo idEncuentro;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugador idJugador;
    @JoinColumn(name = "id_entrenador", referencedColumnName = "documento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idEntrenador;

    public SegumientoEncuentro() {
    }

    public SegumientoEncuentro(Integer idseguimientoEncuentro) {
        this.idseguimientoEncuentro = idseguimientoEncuentro;
    }

    public SegumientoEncuentro(Integer idseguimientoEncuentro, String observacion) {
        this.idseguimientoEncuentro = idseguimientoEncuentro;
        this.observacion = observacion;
    }

    public Integer getIdseguimientoEncuentro() {
        return idseguimientoEncuentro;
    }

    public void setIdseguimientoEncuentro(Integer idseguimientoEncuentro) {
        this.idseguimientoEncuentro = idseguimientoEncuentro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EncuentroTorneo getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(EncuentroTorneo idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public Usuario getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Usuario idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idseguimientoEncuentro != null ? idseguimientoEncuentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegumientoEncuentro)) {
            return false;
        }
        SegumientoEncuentro other = (SegumientoEncuentro) object;
        if ((this.idseguimientoEncuentro == null && other.idseguimientoEncuentro != null) || (this.idseguimientoEncuentro != null && !this.idseguimientoEncuentro.equals(other.idseguimientoEncuentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.SegumientoEncuentro[ idseguimientoEncuentro=" + idseguimientoEncuentro + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idseguimientoEncuentro.toString();
    }

}
