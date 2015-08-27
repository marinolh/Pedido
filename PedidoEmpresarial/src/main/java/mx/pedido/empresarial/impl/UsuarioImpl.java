/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.UsuarioLocal;
import mx.pedido.empresarial.modelo.Usuario;
import mx.pedido.empresarial.modelo.vo.UsuarioVo;

/**
 *
 * @author ihsa
 */
@Stateless
public class UsuarioImpl extends AbstractPedido<Usuario> implements UsuarioLocal {

    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioImpl() {
        super(Usuario.class);
    }

    @Override
    public UsuarioVo buscarPorId(String user) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("select u.id, u.nombre, u.puesto from usuario u where u.eliminad = false and u.id = '").append(user).append("'");
            Object[] objects = (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
            return castUser(objects);
        } catch (Exception e) {
            System.out.println("No se encontró el usuario : : : " + e.getMessage());
            return null;
        }

    }

    private UsuarioVo castUser(Object[] objects) {
        UsuarioVo usuarioVo = new UsuarioVo();
        usuarioVo.setId((String) objects[0]);
        usuarioVo.setNombre((String) objects[1]);
        usuarioVo.setPuesto((String) objects[2]);
        return usuarioVo;
    }

    @Override
    public void guardar(String id, UsuarioVo usuarioVo) {
        try {
            Usuario usuario = new Usuario();
            usuario.setId(idUsuario(usuarioVo.getNombre()));
            usuario.setClave(encriptar("1234"));
            usuario.setNombre(usuarioVo.getNombre());
            usuario.setPuesto(usuarioVo.getPuesto());
            usuario.setGenero(new Usuario(id));
            usuario.setFechaGenero(new Date());
            usuario.setHoraGenero(new Date());
            usuario.setEliminado(Boolean.FALSE);
            //
            create(usuario);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String idUsuario(String id) {

        String[] cadena = id.split(" ");
        String user = cadena[1] + cadena[0].substring(0, 1);
        return user.toUpperCase();
    }
    
    @Override
    public String encriptar(String text) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] b = md.digest(text.getBytes());
            int size = b.length;
            StringBuilder h = new StringBuilder(size);
            for (int i = 0; i < size; i++) {
                int u = b[i] & 255;
                if (u < 16) {
                    h.append(Integer.toHexString(u));
                } else {
                    h.append(Integer.toHexString(u));
                }
            }
            //clave encriptada
            return h.toString();
        } catch (Exception e) {
            return text;
        }
    }

}
