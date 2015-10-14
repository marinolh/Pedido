/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.Envio;

/**
 *
 * @author ihsa
 */
@Local
public interface EnvioLocal {

    void create(Envio envio);

    void edit(Envio envio);

    void remove(Envio envio);

    Envio find(Object id);

    List<Envio> findAll();

    List<Envio> findRange(int[] range);

    int count();

    List traerEstadoPedido(String numeroPedido);

    void guardarEnvio(int pedido, String sesion);
    
}
