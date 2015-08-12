/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.PedidoEstado;

/**
 *
 * @author ihsa
 */
@Local
public interface PedidoEstadoLocal {

    void create(PedidoEstado pedidoEstado);

    void edit(PedidoEstado pedidoEstado);

    void remove(PedidoEstado pedidoEstado);

    PedidoEstado find(Object id);

    List<PedidoEstado> findAll();

    List<PedidoEstado> findRange(int[] range);

    int count();
    
}
