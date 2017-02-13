/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author camila
 */
@Embeddable
public class ItemPK implements Serializable, IDTO{

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_desempe\u00f1o")
    private int idDesempeño;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_valoracion")
    private int idValoracion;

    public ItemPK() {
    }

    public ItemPK(int idDesempeño, int idValoracion) {
        this.idDesempeño = idDesempeño;
        this.idValoracion = idValoracion;
    }

    public int getIdDesempeño() {
        return idDesempeño;
    }

    public void setIdDesempeño(int idDesempeño) {
        this.idDesempeño = idDesempeño;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDesempeño;
        hash += (int) idValoracion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPK)) {
            return false;
        }
        ItemPK other = (ItemPK) object;
        if (this.idDesempeño != other.idDesempeño) {
            return false;
        }
        if (this.idValoracion != other.idValoracion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.ItemPK[ idDesempe\u00f1o=" + idDesempeño + ", idValoracion=" + idValoracion + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
