/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.registro.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.pedido.empresarial.local.ClienteLocal;
import mx.pedido.empresarial.modelo.vo.ClienteVo;
import mx.pedido.sesion.FacesUtils;
import mx.pedido.sesion.Sesion;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ihsa
 */
@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean {

    @EJB
    private ClienteLocal clienteLocal;

    //
    @ManagedProperty(value = "sesion")
    private Sesion sesion;

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }

    private ClienteVo clienteVo;

    public void agregarCliente(ActionEvent event) {
        clienteVo = new ClienteVo();
    }

    public void guardarCliente(ActionEvent event) {
        if (clienteLocal.guardarCliente(sesion.getUsuarioVo().getId(), clienteVo)) {
            clienteVo = null;
//            RequestContext.getCurrentInstance().closeDialog("divPanelAgregar");
        } else {
            FacesUtils.addErrorMessage("Ocurrio un error al guardar el cliente");
        }
    }

    public void cancelarCliente(ActionEvent event) {
        clienteVo = null;
  //      RequestContext.getCurrentInstance().closeDialog("divPanelAgregar");
    }

    public void seleccionar(ActionEvent event) {

    }

    public List getTraerCliente() {
        return clienteLocal.traerCliente();
    }

    /**
     * @return the clienteVo
     */
    public ClienteVo getClienteVo() {
        return clienteVo;
    }

    /**
     * @param clienteVo the clienteVo to set
     */
    public void setClienteVo(ClienteVo clienteVo) {
        this.clienteVo = clienteVo;
    }

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

}
