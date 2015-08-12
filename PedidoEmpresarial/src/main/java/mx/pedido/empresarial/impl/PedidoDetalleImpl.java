/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.PedidoDetalleLocal;
import mx.pedido.empresarial.modelo.PedidoDetalle;

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
    
}
