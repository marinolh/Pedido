/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.EnvioDetalleLocal;
import mx.pedido.empresarial.local.EnvioLocal;
import mx.pedido.empresarial.modelo.Envio;
import mx.pedido.empresarial.modelo.vo.EnvioVo;

/**
 *
 * @author ihsa
 */
@Stateless
public class EnvioImpl extends AbstractPedido<Envio> implements EnvioLocal {

    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnvioImpl() {
        super(Envio.class);
    }
    @EJB
    private EnvioDetalleLocal envioDetalleLocal;

    @Override
    public List traerEstadoPedido(String numeroPedido) {
        List<EnvioVo> lo = new ArrayList<EnvioVo>();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select v.numero_envio, v.fecha_envio, v.hora_envio, p.numero, e.nombre, f.numero from envio v  ");
            sb.append("     inner joion pedido p on v.pedido = p.id");
            sb.append("     inner join estado e on v.estado = e.id");
            sb.append("     inner join factura f on v.factura = f.id ");
            sb.append(" where p.numero_pedido = '").append(numeroPedido).append("'");
            sb.append(" and p.eliminado = '").append(Boolean.FALSE);
            //
            List<Object[]> loList = em.createNativeQuery(sb.toString()).getResultList();
            for (Object[] envioVo : loList) {
                lo.add(castEnvio(envioVo));
            }
        } catch (Exception e) {
            System.out.println("Exv: : : : " + e.getMessage());
        }
        return lo;
    }

    private EnvioVo castEnvio(Object[] object) {
        EnvioVo envioVo = new EnvioVo();
        envioVo.setNumero((String) object[0]);
        envioVo.setFechaEnvio((Date) object[1]);
        envioVo.setHoraSalida((Date) object[2]);
        envioVo.setPedido((String) object[3]);
        envioVo.setEstado((String) object[4]);
        envioVo.setFactura((String) object[5]);
        envioVo.setId((Integer) object[6]);
        envioVo.setListaDetalle(envioDetalleLocal.traerDetalleEnvio(envioVo.getId()));
        return envioVo;
    }

}
