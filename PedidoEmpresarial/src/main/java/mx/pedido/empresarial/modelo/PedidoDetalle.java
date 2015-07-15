/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ihsa
 */
@Entity
@Table(name = "pedido_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidoDetalle.findAll", query = "SELECT p FROM PedidoDetalle p"),
    @NamedQuery(name = "PedidoDetalle.findById", query = "SELECT p FROM PedidoDetalle p WHERE p.id = :id"),
    @NamedQuery(name = "PedidoDetalle.findByPrecio", query = "SELECT p FROM PedidoDetalle p WHERE p.precio = :precio"),
    @NamedQuery(name = "PedidoDetalle.findByCantidad", query = "SELECT p FROM PedidoDetalle p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "PedidoDetalle.findByEstado", query = "SELECT p FROM PedidoDetalle p WHERE p.estado = :estado"),
    @NamedQuery(name = "PedidoDetalle.findByProducto", query = "SELECT p FROM PedidoDetalle p WHERE p.producto = :producto"),
    @NamedQuery(name = "PedidoDetalle.findByEliminado", query = "SELECT p FROM PedidoDetalle p WHERE p.eliminado = :eliminado"),
    @NamedQuery(name = "PedidoDetalle.findByFechaGenero", query = "SELECT p FROM PedidoDetalle p WHERE p.fechaGenero = :fechaGenero")})
public class PedidoDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "producto")
    private Integer producto;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @OneToMany(mappedBy = "pedidoDetalle")
    private Collection<EnvioDetalle> envioDetalleCollection;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Usuario genero;
    @JoinColumn(name = "pedido", referencedColumnName = "id")
    @ManyToOne
    private Pedido pedido;

    public PedidoDetalle() {
    }

    public PedidoDetalle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
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

    @XmlTransient
    public Collection<EnvioDetalle> getEnvioDetalleCollection() {
        return envioDetalleCollection;
    }

    public void setEnvioDetalleCollection(Collection<EnvioDetalle> envioDetalleCollection) {
        this.envioDetalleCollection = envioDetalleCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoDetalle)) {
            return false;
        }
        PedidoDetalle other = (PedidoDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.PedidoDetalle[ id=" + id + " ]";
    }
    
}
