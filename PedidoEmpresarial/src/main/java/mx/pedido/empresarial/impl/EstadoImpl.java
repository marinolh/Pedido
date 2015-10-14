/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.EstadoLocal;
import mx.pedido.empresarial.modelo.Estado;

/**
 *
 * @author ihsa
 */
@Stateless
public class EstadoImpl extends AbstractPedido<Estado> implements EstadoLocal {
    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoImpl() {
        super(Estado.class);
    }
    
}
