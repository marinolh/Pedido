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
    @Size(max = 256)
    @Column(name = "llega")
    private String llega;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Column(name = "hora_salida")
    @Temporal(TemporalType.DATE)
    private Date horaEnvio;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @Column(name = "hora_llegada")
    @Temporal(TemporalType.DATE)
    private Date horaLlegada;
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
