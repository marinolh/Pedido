/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.registro.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.pedido.empresarial.local.UsuarioLocal;
import mx.pedido.empresarial.modelo.vo.UsuarioVo;
import mx.pedido.sesion.Sesion;

/**
 *
 * @author ihsa
 */
@Named(value = "usuarioBean")
@ViewScoped
public class UsuarioBean {

    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    @EJB
    private UsuarioLocal usuarioLocal;
    @ManagedProperty(value = "sesion")
    private Sesion sesion;
    private UsuarioVo usuarioVo;

    public void guardar(ActionEvent event) {
        usuarioLocal.guardar(sesion.getUsuarioVo().getId(), getUsuarioVo());
    }

    public void cancelar(ActionEvent event) {
    }

    public void agregarUsuario(ActionEvent event) {
        usuarioVo = new UsuarioVo();
    }

    public void seleccionar(ActionEvent event) {

    }

    public List getTraerUsuario() {
        return usuarioLocal.findAll();
    }

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

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

}
