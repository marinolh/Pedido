/*
 */
package mx.pedido.empresarial.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import mx.pedido.empresarial.local.FolioLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.modelo.Folio;

/**
 *
 * @author mluis
 */
@Stateless
public class FolioImpl extends AbstractPedido<Folio> implements FolioLocal {

    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FolioImpl() {
        super(Folio.class);
    }

    @Override
    public List<Folio> findAll() {
        return em.createQuery("select object(o) from Folio as o").getResultList();
    }

    @Override
    public int getFolio(Object nombreComprobante) {
        Folio folio = (Folio) em.createQuery("SELECT f FROM Folio f WHERE f.comprobante = :comprobante")
                .setParameter("comprobante", nombreComprobante)
                .getSingleResult();
        // aqui checar el año si es igual suma el consecutivo si es diferente inicializa el consecutivo a 0        
        if (folio.getAnio() != null) {
            String anoActual = getDigitosAño(new Date());
            if (anoActual.equals(folio.getAnio())) {
            } else {
                folio.setAnio(anoActual);
                folio.setValor(0);
            }
        }
        folio.setValor(folio.getValor() + 1);
        edit(folio);
        //-----------------------------------------
        return folio.getValor();
    }

    private String getDigitosAño(Date fecha) {
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        String Cadena = SDF.format(fecha);
        String Resultado = "";
        for (int i = 0; i < Cadena.length(); i++) {
            if (i > 7) {
                Resultado = Resultado + Cadena.charAt(i);
            }
        }
        return Resultado;
    }

    @Override
    public String getFolio(String nombreComprobante) {
        Folio folio = (Folio) em.createQuery("SELECT f FROM Folio f WHERE f.comprobante = :comprobante").setParameter("comprobante", nombreComprobante).getSingleResult();
        if (folio.getAnio() != null) {
            String anoActual = getDigitosAño(new Date());
            if (anoActual.equals(folio.getAnio())) {
            } else {
                folio.setAnio(anoActual);
                folio.setValor(0);
            }
        }
        //---Actualizo el nuevo valor
        folio.setValor(folio.getValor() + 1);
        edit(folio);
        //-----------------------------------------
        return ((folio.getPrefijo() != null ? folio.getPrefijo() : "") + folio.getAnio() + Integer.toString(folio.getValor()));
    }

    @Override
    public String traerAnioFolio(String nombreComprobante) {
        Folio folio = (Folio) em.createQuery("SELECT f FROM Folio f WHERE f.comprobante = :comprobante").setParameter("comprobante", nombreComprobante).getSingleResult();
        if (folio.getAnio() != null) {
            String anoActual = getDigitosAño(new Date());
            if (anoActual.equals(folio.getAnio())) {
            } else {
                folio.setAnio(anoActual);
                folio.setValor(0);
            }
        }
        //---Actualizo el nuevo valor
        folio.setValor(folio.getValor() + 1);
        edit(folio);
        //-----------------------------------------
        return (folio.getAnio() + "-" + Integer.toString(folio.getValor()));
    }
}
