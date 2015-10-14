/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.MonedaLocal;
import mx.pedido.empresarial.modelo.Moneda;

/**
 *
 * @author ihsa
 */
@Stateless
public class MonedaImpl extends AbstractPedido<Moneda> implements MonedaLocal {
    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MonedaImpl() {
        super(Moneda.class);
    }
    
}