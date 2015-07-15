/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author ihsa
 */
@Entity
@Table(name = "pedido_estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoEstado.findAll", query = "SELECT p FROM PedidoEstado p"),
    @NamedQuery(name = "PedidoEstado.findById", query = "SELECT p FROM PedidoEstado p WHERE p.id = :id"),
    @NamedQuery(name = "PedidoEstado.findByObservacion", query = "SELECT p FROM PedidoEstado p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "PedidoEstado.findByEliminado", query = "SELECT p FROM PedidoEstado p WHERE p.eliminado = :eliminado"),
    @NamedQuery(name = "PedidoEstado.findByFechaGenero", query = "SELECT p FROM PedidoEstado p WHERE p.fechaGenero = :fechaGenero")})
public class PedidoEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 1024)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Usuario genero;
    @JoinColumn(name = "pedido", referencedColumnName = "id")
    @ManyToOne
    private Pedido pedido;
    @JoinColumn(name = "estado", referencedColumnName = "id")
    @ManyToOne
    private Estado estado;

    public PedidoEstado() {
    }

    public PedidoEstado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Date getFechaGenero() {
        return fechaGenero;
    }

    public void setFechaGenero(Date fechaGenero) {
        this.fechaGenero = fechaGenero;
    }

    public Usuario getGenero() {
        return genero;
    }

    public void setGenero(Usuario genero) {
        this.genero = genero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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
        if (!(object instanceof PedidoEstado)) {
            return false;
        }
        PedidoEstado other = (PedidoEstado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.PedidoEstado[ id=" + id + " ]";
    }
    
}
