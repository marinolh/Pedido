/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ihsa
 */
@Entity
@Table(name = "envio_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnvioDetalle.findAll", query = "SELECT e FROM EnvioDetalle e"),
    @NamedQuery(name = "EnvioDetalle.findById", query = "SELECT e FROM EnvioDetalle e WHERE e.id = :id"),
    @NamedQuery(name = "EnvioDetalle.findByEliminado", query = "SELECT e FROM EnvioDetalle e WHERE e.eliminado = :eliminado")})
public class EnvioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Usuario genero;
    @JoinColumn(name = "pedido_detalle", referencedColumnName = "id")
    @ManyToOne
    private PedidoDetalle pedidoDetalle;
    @JoinColumn(name = "envio", referencedColumnName = "id")
    @ManyToOne
    private Envio envio;

    public EnvioDetalle() {
    }

    public EnvioDetalle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Usuario getGenero() {
        return genero;
    }

    public void setGenero(Usuario genero) {
        this.genero = genero;
    }

    public PedidoDetalle getPedidoDetalle() {
        return pedidoDetalle;
    }

    public void setPedidoDetalle(PedidoDetalle pedidoDetalle) {
        this.pedidoDetalle = pedidoDetalle;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnvioDetalle)) {
            return false;
        }
        EnvioDetalle other = (EnvioDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.EnvioDetalle[ id=" + id + " ]";
    }
    
}
