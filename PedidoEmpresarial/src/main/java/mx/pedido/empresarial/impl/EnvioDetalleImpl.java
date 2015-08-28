/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.EnvioDetalleLocal;
import mx.pedido.empresarial.modelo.EnvioDetalle;
import mx.pedido.empresarial.modelo.vo.DetalleEnvioVo;

/**
 *
 * @author ihsa
 */
@Stateless
public class EnvioDetalleImpl extends AbstractPedido<EnvioDetalle> implements EnvioDetalleLocal {
    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnvioDetalleImpl() {
        super(EnvioDetalle.class);
    }

    @Override
    public List<DetalleEnvioVo> traerDetalleEnvio(int idEnvio) {
        List<DetalleEnvioVo> ld = new ArrayList<DetalleEnvioVo>();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from envio_detalle ed ");
        sb.append("     inner join pedido_detalle pd on ed.pedido_detalle = pd.id ");
        sb.append("     inner join ");
        sb.append("     inner join ");
        sb.append(" where ed.pedido_detalle = ").append(idEnvio);
        sb.append(" and ed.eliminado = ").append(Boolean.FALSE);
        //
        List<Object[]> lo = em.createNativeQuery("").getResultList();
        for (Object[] obj : lo) {
            ld.add(castDetalleEnvio(obj));
        }
        return ld;
    }

    private DetalleEnvioVo castDetalleEnvio(Object[] obj) {
        DetalleEnvioVo detalleEnvioVo = new DetalleEnvioVo();
                
        return detalleEnvioVo;
    }
    
}
