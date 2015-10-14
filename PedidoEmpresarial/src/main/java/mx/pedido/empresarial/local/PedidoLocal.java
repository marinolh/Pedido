/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.Pedido;
import mx.pedido.empresarial.modelo.vo.PedidoVo;
import mx.pedido.empresarial.modelo.vo.ProductoVo;

/**
 *
 * @author ihsa
 */
@Local
public interface PedidoLocal {

    void create(Pedido pedido);

    void edit(Pedido pedido);

    void remove(Pedido pedido);

    Pedido find(Object id);

    List<Pedido> findAll();

    List<Pedido> findRange(int[] range);

    int count();

    boolean guardar(String sesion, PedidoVo pedidoVo, Integer cliente, List<ProductoVo> productos);

    PedidoVo buscarPedido(String codigo);

    List traerPedido(int estado);

}
