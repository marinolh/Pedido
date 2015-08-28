/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.EnvioDetalle;
import mx.pedido.empresarial.modelo.vo.DetalleEnvioVo;

/**
 *
 * @author ihsa
 */
@Local
public interface EnvioDetalleLocal {

    void create(EnvioDetalle envioDetalle);

    void edit(EnvioDetalle envioDetalle);

    void remove(EnvioDetalle envioDetalle);

    EnvioDetalle find(Object id);

    List<EnvioDetalle> findAll();

    List<EnvioDetalle> findRange(int[] range);

    int count();

    List<DetalleEnvioVo> traerDetalleEnvio(int id);
    
}
