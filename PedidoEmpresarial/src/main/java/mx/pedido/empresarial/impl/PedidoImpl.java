/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.PedidoLocal;
import mx.pedido.empresarial.modelo.Pedido;

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

    public PedidoImpl() {
        super(Pedido.class);
    }
    
}
