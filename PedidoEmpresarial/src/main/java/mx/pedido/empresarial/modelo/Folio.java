/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hacosta
 */
@Entity
@Getter
@Setter
@Table(name = "FOLIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Folio.findAll", query = "SELECT f FROM Folio f")})
public class Folio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 60)
    @Column(name = "COMPROBANTE")
    private String comprobante;
    @Size(max = 10)
    @Column(name = "ANIO")
    private String anio;
    @Column(name = "VALOR")
    private Integer valor;
    @Column(name = "PREFIJO")
    private String prefijo;

    public Folio() {
    }

    public Folio(Integer id) {
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
        if (!(object instanceof Folio)) {
            return false;
        }
        Folio other = (Folio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.pedido.empresarial.modelo.folio[ id=" + id + " ]";
    }

}
