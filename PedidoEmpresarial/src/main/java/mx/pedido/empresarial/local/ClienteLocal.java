/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.Cliente;
import mx.pedido.empresarial.modelo.vo.ClienteVo;

/**
 *
 * @author ihsa
 */
@Local
public interface ClienteLocal {

    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    int count();

    /**
     *
     * @param id
     * @param clienteVo
     * @return
     */
    boolean guardarCliente(String id, ClienteVo clienteVo);

    List traerCliente();
    
}
