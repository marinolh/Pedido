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
import mx.pedido.empresarial.constante.Constantes;
import mx.pedido.empresarial.local.EnvioLocal;
import mx.pedido.empresarial.local.FolioLocal;
import mx.pedido.empresarial.local.PedidoDetalleLocal;
import mx.pedido.empresarial.local.PedidoLocal;
import mx.pedido.empresarial.modelo.Cliente;
import mx.pedido.empresarial.modelo.Moneda;
import mx.pedido.empresarial.modelo.Pedido;
import mx.pedido.empresarial.modelo.Usuario;
import mx.pedido.empresarial.modelo.vo.PedidoVo;
import mx.pedido.empresarial.modelo.vo.ProductoVo;

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
    @EJB
    private FolioLocal folioLocal;
    @EJB
    private EnvioLocal envioLocal;
    @EJB
    private PedidoDetalleLocal pedidoDetalleLocal;

    public PedidoImpl() {
        super(Pedido.class);
    }

    @Override
    public boolean guardar(String sesion, PedidoVo pedidoVo, Integer cliente, List<ProductoVo> productos) {
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
            // Se registra el envio
            envioLocal.guardarEnvio(pedido.getId(), sesion);
            //
            for (ProductoVo producto : productos) {
                pedidoDetalleLocal.gurdar(sesion, producto, pedido.getId());
            }

        } catch (Exception e) {
            v = false;
        }
        return v;
    }

    @Override
    public PedidoVo buscarPedido(String codigo) {
        PedidoVo pedidoVo = new PedidoVo();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(consulta());
            sb.append("     where p.codigo = '").append(codigo).append("'");
            sb.append("     and p.eliminado = ").append(Boolean.FALSE);
            Object[] objPedido = (Object[]) em.createQuery(sb.toString()).getSingleResult();
            pedidoVo = castPedido(objPedido);
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
        return folioLocal.getFolio(Constantes.COMPROBANTE_CODIGO_PEDIDO);
    }

    private PedidoVo castPedido(Object[] obj) {
        PedidoVo pedidoVo = new PedidoVo();
        pedidoVo.setNumero((String) obj[0]);
        pedidoVo.setCodigo((String) obj[1]);
        pedidoVo.getClienteVo().setNombre((String) obj[2]);
        pedidoVo.getClienteVo().setDireccion((String) obj[3]);
        pedidoVo.setFechaSalida((Date) obj[4]);
        pedidoVo.setHoraSalida((Date) obj[5]);
        pedidoVo.setImpuesto((Double) obj[6]);
        pedidoVo.setTotal((Double) obj[7]);
        pedidoVo.setSubtotal((Double) obj[8]);
        pedidoVo.setIdMoneda((Integer) obj[9]);
        pedidoVo.setMoneda((String) obj[10]);
        pedidoVo.setObservacion((String) obj[11]);
        return pedidoVo;
    }

    @Override
    public List traerPedido(int estado) {
        //To change body of generated methods, choose Tools | Templates.

        List<PedidoVo> lpedido = new ArrayList<PedidoVo>();

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(consulta());
            sb.append("  where v.estado = ").append(estado);
            sb.append("  and v.eliminado = ").append(Boolean.FALSE);
//
            List<Object[]> lo = em.createNativeQuery(sb.toString()).getResultList();
            for (Object[] lo1 : lo) {
                lpedido.add(castPedido(lo1));
            }
        } catch (Exception e) {
            System.out.println("Exc al traer pedido : : : " + e.getMessage());
        }
        return lpedido;
    }

    private String consulta() {
        StringBuilder sb = new StringBuilder();
        sb.append("select p.numero, p.codigo, c.nombre, c.direccion, p.fecha_salida, p.hora_salida, p.impuesto, p.total, p.subtotal, p.moneda, m.siglas, p.observacion  from pedido p ");
        sb.append("     inner join cliente c on p.cliente = c.id");
        sb.append("     inner join moneda m on p.moneda = m.id ");
        sb.append("     inner join envio v on v.pedido = p.id");
        sb.append("     inner join estado e on v.estado = e.id");
        return sb.toString();
    }
}
