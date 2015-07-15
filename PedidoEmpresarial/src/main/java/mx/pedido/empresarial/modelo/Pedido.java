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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ihsa
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
    @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pedido.findByTotal", query = "SELECT p FROM Pedido p WHERE p.total = :total"),
    @NamedQuery(name = "Pedido.findBySubtotal", query = "SELECT p FROM Pedido p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "Pedido.findByImpuesto", query = "SELECT p FROM Pedido p WHERE p.impuesto = :impuesto"),
    @NamedQuery(name = "Pedido.findByCliente", query = "SELECT p FROM Pedido p WHERE p.cliente = :cliente"),
    @NamedQuery(name = "Pedido.findByEliminado", query = "SELECT p FROM Pedido p WHERE p.eliminado = :eliminado"),
    @NamedQuery(name = "Pedido.findByFechaGenero", query = "SELECT p FROM Pedido p WHERE p.fechaGenero = :fechaGenero")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 24)
    @Column(name = "numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "impuesto")
    private Double impuesto;
    @Column(name = "cliente")
    private Integer cliente;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @OneToMany(mappedBy = "pedido")
    private Collection<Envio> envioCollection;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Usuario genero;
    @JoinColumn(name = "moneda", referencedColumnName = "id")
    @ManyToOne
    private Moneda moneda;
    @OneToMany(mappedBy = "pedido")
    private Collection<PedidoEstado> pedidoEstadoCollection;
    @OneToMany(mappedBy = "pedido")
    private Collection<PedidoDetalle> pedidoDetalleCollection;

    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
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
    public Collection<Envio> getEnvioCollection() {
        return envioCollection;
    }

    public void setEnvioCollection(Collection<Envio> envioCollection) {
        this.envioCollection = envioCollection;
    }

    public Usuario getGenero() {
        return genero;
    }

    public void setGenero(Usuario genero) {
        this.genero = genero;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    @XmlTransient
    public Collection<PedidoEstado> getPedidoEstadoCollection() {
        return pedidoEstadoCollection;
    }

    public void setPedidoEstadoCollection(Collection<PedidoEstado> pedidoEstadoCollection) {
        this.pedidoEstadoCollection = pedidoEstadoCollection;
    }

    @XmlTransient
    public Collection<PedidoDetalle> getPedidoDetalleCollection() {
        return pedidoDetalleCollection;
    }

    public void setPedidoDetalleCollection(Collection<PedidoDetalle> pedidoDetalleCollection) {
        this.pedidoDetalleCollection = pedidoDetalleCollection;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.Pedido[ id=" + id + " ]";
    }
    
}
