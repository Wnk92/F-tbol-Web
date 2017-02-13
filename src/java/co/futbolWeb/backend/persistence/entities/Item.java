/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIdDesempe\u00f1o", query = "SELECT i FROM Item i WHERE i.itemPK.idDesempe\u00f1o = :idDesempe\u00f1o"),
    @NamedQuery(name = "Item.findByIdValoracion", query = "SELECT i FROM Item i WHERE i.itemPK.idValoracion = :idValoracion"),
    @NamedQuery(name = "Item.findByCantidadItems", query = "SELECT i FROM Item i WHERE i.cantidadItems = :cantidadItems"),
    @NamedQuery(name = "Item.findByItemsAprobados", query = "SELECT i FROM Item i WHERE i.itemsAprobados = :itemsAprobados")})
public class Item implements Serializable, IDTO {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPK itemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_items")
    private int cantidadItems;
    @Basic(optional = false)
    @NotNull
    @Column(name = "items_aprobados")
    private int itemsAprobados;
    @JoinColumn(name = "id_desempe\u00f1o", referencedColumnName = "id_desempe\u00f1o", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Desempeño desempeño;
    @JoinColumn(name = "id_valoracion", referencedColumnName = "id_valoracion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Valoracion valoracion;

    public Item() {
    }

    public Item(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public Item(ItemPK itemPK, int cantidadItems, int itemsAprobados) {
        this.itemPK = itemPK;
        this.cantidadItems = cantidadItems;
        this.itemsAprobados = itemsAprobados;
    }

    public Item(int idDesempeño, int idValoracion) {
        this.itemPK = new ItemPK(idDesempeño, idValoracion);
    }

    public ItemPK getItemPK() {
        return itemPK;
    }

    public void setItemPK(ItemPK itemPK) {
        this.itemPK = itemPK;
    }

    public int getCantidadItems() {
        return cantidadItems;
    }

    public void setCantidadItems(int cantidadItems) {
        this.cantidadItems = cantidadItems;
    }

    public int getItemsAprobados() {
        return itemsAprobados;
    }

    public void setItemsAprobados(int itemsAprobados) {
        this.itemsAprobados = itemsAprobados;
    }

    public Desempeño getDesempeño() {
        return desempeño;
    }

    public void setDesempeño(Desempeño desempeño) {
        this.desempeño = desempeño;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPK != null ? itemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemPK == null && other.itemPK != null) || (this.itemPK != null && !this.itemPK.equals(other.itemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.futbolWeb.backend.persistence.entities.Item[ itemPK=" + itemPK + " ]";
    }

    @Override
    public String obtenerLlavePrimaria() {
        return itemPK.toString();
    }

}
