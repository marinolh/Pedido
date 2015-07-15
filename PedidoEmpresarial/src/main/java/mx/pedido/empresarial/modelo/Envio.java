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
@Table(name = "envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envio.findAll", query = "SELECT e FROM Envio e"),
    @NamedQuery(name = "Envio.findById", query = "SELECT e FROM Envio e WHERE e.id = :id"),
    @NamedQuery(name = "Envio.findByNumeroEnvio", query = "SELECT e FROM Envio e WHERE e.numeroEnvio = :numeroEnvio"),
    @NamedQuery(name = "Envio.findByFechaEnvio", query = "SELECT e FROM Envio e WHERE e.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "Envio.findByHoraEnvio", query = "SELECT e FROM Envio e WHERE e.horaEnvio = :horaEnvio"),
    @NamedQuery(name = "Envio.findByFactura", query = "SELECT e FROM Envio e WHERE e.factura = :factura"),
    @NamedQuery(name = "Envio.findByEliminado", query = "SELECT e FROM Envio e WHERE e.eliminado = :eliminado"),
    @NamedQuery(name = "Envio.findByFechaGenero", query = "SELECT e FROM Envio e WHERE e.fechaGenero = :fechaGenero")})
public class Envio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 24)
    @Column(name = "numero_envio")
    private String numeroEnvio;
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Column(name = "hora_envio")
    @Temporal(TemporalType.DATE)
    private Date horaEnvio;
    @Column(name = "factura")
    private Integer factura;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @OneToMany(mappedBy = "envio")
    private Collection<EnvioDetalle> envioDetalleCollection;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private Usuario genero;
    @JoinColumn(name = "pedido", referencedColumnName = "id")
    @ManyToOne
    private Pedido pedido;

    public Envio() {
    }

    public Envio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(String numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Date horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
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
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.Envio[ id=" + id + " ]";
    }
    
}
