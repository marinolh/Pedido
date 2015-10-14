/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.PedidoDetalleLocal;
import mx.pedido.empresarial.modelo.Pedido;
import mx.pedido.empresarial.modelo.PedidoDetalle;
import mx.pedido.empresarial.modelo.Producto;
import mx.pedido.empresarial.modelo.Usuario;
import mx.pedido.empresarial.modelo.vo.ProductoVo;

/**
 *
 * @author ihsa
 */
@Stateless
public class PedidoDetalleImpl extends AbstractPedido<PedidoDetalle> implements PedidoDetalleLocal {

    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoDetalleImpl() {
        super(PedidoDetalle.class);
    }

    @Override
    public void gurdar(String sesion, ProductoVo producto, int pedido) {
        //To change body of generated methods, choose Tools | Templates.
        PedidoDetalle pedidoDetalle = new PedidoDetalle();
        pedidoDetalle.setProducto(new Producto(producto.getId()));
        pedidoDetalle.setCantidad(producto.getCantidad());
        pedidoDetalle.setPedido(new Pedido(pedido));
        pedidoDetalle.setPrecio(producto.getPrecio());
        pedidoDetalle.setGenero(new Usuario(sesion));
        pedidoDetalle.setFechaGenero(new Date());
        pedidoDetalle.setHoraGenero(new Date());
        create(pedidoDetalle);
    }

}
