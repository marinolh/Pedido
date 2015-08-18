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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByPuesto", query = "SELECT u FROM Usuario u WHERE u.puesto = :puesto"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByEliminado", query = "SELECT u FROM Usuario u WHERE u.eliminado = :eliminado"),
    @NamedQuery(name = "Usuario.findByFechaGenero", query = "SELECT u FROM Usuario u WHERE u.fechaGenero = :fechaGenero")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id")
    private String id;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 64)
    @Column(name = "puesto")
    private String puesto;
    @Size(max = 64)
    @Column(name = "clave")
    private String clave;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @OneToMany(mappedBy = "genero")
    private Collection<EnvioDetalle> envioDetalleCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<Envio> envioCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<Estado> estadoCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<Factura> facturaCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Usuario genero;
    @OneToMany(mappedBy = "genero")
    private Collection<Moneda> monedaCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<Pedido> pedidoCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<Producto> productoCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<PedidoEstado> pedidoEstadoCollection;
    @OneToMany(mappedBy = "genero")
    private Collection<PedidoDetalle> pedidoDetalleCollection;

    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    @XmlTransient
    public Collection<Envio> getEnvioCollection() {
        return envioCollection;
    }

    public void setEnvioCollection(Collection<Envio> envioCollection) {
        this.envioCollection = envioCollection;
    }

    @XmlTransient
    public Collection<Estado> getEstadoCollection() {
        return estadoCollection;
    }

    public void setEstadoCollection(Collection<Estado> estadoCollection) {
        this.estadoCollection = estadoCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Usuario getGenero() {
        return genero;
    }

    public void setGenero(Usuario genero) {
        this.genero = genero;
    }

    @XmlTransient
    public Collection<Moneda> getMonedaCollection() {
        return monedaCollection;
    }

    public void setMonedaCollection(Collection<Moneda> monedaCollection) {
        this.monedaCollection = monedaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @XmlTransient
    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.Usuario[ id=" + id + " ]";
    }
    
}
