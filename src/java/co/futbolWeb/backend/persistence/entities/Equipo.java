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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByNombreEquipo", query = "SELECT e FROM Equipo e WHERE e.nombreEquipo = :nombreEquipo")})
public class Equipo implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEquipo", fetch = FetchType.EAGER)
    private List<Jugador> jugadorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEquipo", fetch = FetchType.EAGER)
    private List<HorarioClub> horarioClubList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo", fetch = FetchType.EAGER)
    private List<ParticipacionTorneo> participacionTorneoList;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "documento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario fkIdUsuario;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categoria fkIdCategoria;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String nombreEquipo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    @XmlTransient
    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    @XmlTransient
    public List<HorarioClub> getHorarioClubList() {
        return horarioClubList;
    }

    public void setHorarioClubList(List<HorarioClub> horarioClubList) {
        this.horarioClubList = horarioClubList;
    }

    @XmlTransient
    public List<ParticipacionTorneo> getParticipacionTorneoList() {
        return participacionTorneoList;
    }

    public void setParticipacionTorneoList(List<ParticipacionTorneo> participacionTorneoList) {
        this.participacionTorneoList = participacionTorneoList;
    }

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public Categoria getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(Categoria fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.Equipo[ idEquipo=" + idEquipo + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return idEquipo.toString();
    }

}
