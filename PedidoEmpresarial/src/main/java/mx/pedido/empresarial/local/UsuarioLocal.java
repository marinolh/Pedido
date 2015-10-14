/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.local;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Local;
import mx.pedido.empresarial.modelo.Usuario;
import mx.pedido.empresarial.modelo.vo.UsuarioVo;

/**
 *
 * @author ihsa
 */
@Local
public interface UsuarioLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    UsuarioVo buscarPorId(String user);

    void guardar(String id, UsuarioVo usuarioVo);

    String encriptar(String text) throws NoSuchAlgorithmException;
    
}
