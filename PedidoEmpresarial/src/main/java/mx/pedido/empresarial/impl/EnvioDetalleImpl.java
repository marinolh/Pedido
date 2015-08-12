/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.EnvioDetalleLocal;
import mx.pedido.empresarial.modelo.EnvioDetalle;

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
    
}
