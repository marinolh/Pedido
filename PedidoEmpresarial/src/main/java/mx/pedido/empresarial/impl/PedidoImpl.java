/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.FolioLocal;
import mx.pedido.empresarial.local.PedidoLocal;
import mx.pedido.empresarial.modelo.Cliente;
import mx.pedido.empresarial.modelo.Moneda;
import mx.pedido.empresarial.modelo.Pedido;
import mx.pedido.empresarial.modelo.Usuario;
import mx.pedido.empresarial.modelo.vo.PedidoVo;

/**
 *
 * @author ihsa
 */
@Stateless
public class PedidoImpl extends AbstractPedido<Pedido> implements PedidoLocal {

@PersistenceContext(unitName = "PedidoEmpresarialPU")
private EntityManager em;

@Override
protected EntityManager getEntityManager() {
    return em;
}
private static String COMPROBANTE_CODIGO_PEDIDO = "COD_PED";
@EJB
private FolioLocal folioLocal;

public PedidoImpl() {
    super(Pedido.class);
}

@Override
public boolean guardar(String sesion, PedidoVo pedidoVo, Integer cliente) {
    boolean v = true;
    try {
        Pedido pedido = new Pedido();
        pedido.setCliente(new Cliente(cliente));
        pedido.setCodigo(generarCodigo());
        pedido.setNumero(generarNumeroPedido());
        pedido.setMoneda(new Moneda(pedidoVo.getIdMoneda()));
        pedido.setObservacion(pedidoVo.getObservacion());
        pedido.setTotal(pedidoVo.getTotal());
        pedido.setSubtotal(pedidoVo.getSubtotal());
        pedido.setImpuesto(pedidoVo.getImpuesto());
        pedido.setGenero(new Usuario(sesion));
        pedido.setFechaGenero(new Date());
        pedido.setHoraGenero(new Date());
        pedido.setEliminado(Boolean.FALSE);
        create(pedido);
    } catch (Exception e) {
        v = false;
    }
    return v;
}

public PedidoVo buscarPedido(String codigo) {
    PedidoVo pedidoVo = new PedidoVo();
    try {
        StringBuilder sb = new StringBuilder();
        sb.append("select p.numero, p.codigo, c.nombre, c.direccion, p.fecha_salida  from pedido p ");
        sb.append("     inner join cliente c on p.cliente = c.id");
        sb.append("     inner join moneda m on p.moneda = m.id ");
        sb.append("     where p.codigo = '").append(codigo).append("'");
        sb.append("     and p.eliminado = ").append(Boolean.FALSE);
        Object[] objPedido = (Object[]) em.createQuery(sb.toString()).getSingleResult();
        pedidoVo = castPedodo(objPedido);
    } catch (Exception e) {
        pedidoVo = null;
    }
    return pedidoVo;
}

private String generarNumeroPedido() {
    //
    return "";
}

private String generarCodigo() {
    return folioLocal.getFolio(COMPROBANTE_CODIGO_PEDIDO);
}

private PedidoVo castPedodo(Object[] lo1) {
    PedidoVo pedidoVo = new PedidoVo();
    return pedidoVo;
}

}
