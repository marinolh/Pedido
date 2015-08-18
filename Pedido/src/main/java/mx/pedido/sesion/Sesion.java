/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.sesion;

import javax.faces.bean.SessionScoped;
import mx.pedido.empresarial.modelo.vo.UsuarioVo;

/**
 *
 * @author ihsa
 */
@SessionScoped
public class Sesion {
    
    private UsuarioVo usuarioVo;

    /**
     * @return the usuarioVo
     */
    public UsuarioVo getUsuarioVo() {
        return usuarioVo;
    }

    /**
     * @param usuarioVo the usuarioVo to set
     */
    public void setUsuarioVo(UsuarioVo usuarioVo) {
        this.usuarioVo = usuarioVo;
    }
    
}
