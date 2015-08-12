/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.PedidoDetalle;

/**
 *
 * @author ihsa
 */
@Local
public interface PedidoDetalleLocal {

    void create(PedidoDetalle pedidoDetalle);

    void edit(PedidoDetalle pedidoDetalle);

    void remove(PedidoDetalle pedidoDetalle);

    PedidoDetalle find(Object id);

    List<PedidoDetalle> findAll();

    List<PedidoDetalle> findRange(int[] range);

    int count();
    
}
