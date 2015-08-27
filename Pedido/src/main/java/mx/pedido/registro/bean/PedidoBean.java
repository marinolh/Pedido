/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.registro.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.pedido.empresarial.local.PedidoLocal;
import mx.pedido.empresarial.modelo.vo.ClienteVo;
import mx.pedido.empresarial.modelo.vo.PedidoVo;
import mx.pedido.sesion.FacesUtils;
import mx.pedido.sesion.Sesion;

/**
 *
 * @author ihsa
 */
@Named(value = "pedido")
@ViewScoped
public class PedidoBean {

    /**
     * Creates a new instance of Pedido
     */
    public PedidoBean() {
    }
    @EJB
    private PedidoLocal pedidoLocal;
    //
    private PedidoVo pedidoVo;
    private String cliente;
    private int idCliente;

    @ManagedProperty(value = "sesion")
    private Sesion sesion;

    //
    @PostConstruct
    public void iniciar() {
        //llenar clientes

    }

    public List<ClienteVo> completeTheme(String query) {
        List<ClienteVo> listaCliente = traerCliente();
        List<ClienteVo> filteredThemes = new ArrayList();

        for (ClienteVo nombre : listaCliente) {
            if (nombre.getNombre().toLowerCase().startsWith(query)) {
                filteredThemes.add(nombre);
            }
        }

        return filteredThemes;
    }

    public List<ClienteVo> traerCliente() {
        List<ClienteVo> lista = new ArrayList<>();
        return lista;
    }

    public void guardar(ActionEvent event) {
        if (pedidoLocal.guardar(sesion.getUsuarioVo().getId(), getPedidoVo(), getIdCliente())) {
            FacesUtils.addInfoMessage("Se registró el pedido . . . ");
            pedidoVo = null;
        } else {
            FacesUtils.addErrorMessage("Ocurrio un error, favor de verificar.");
        }
    }

    public void cancelar(ActionEvent event) {
    }

    /**
     * @return the pedidoVo
     */
    public PedidoVo getPedidoVo() {
        return pedidoVo;
    }

    /**
     * @param pedidoVo the pedidoVo to set
     */
    public void setPedidoVo(PedidoVo pedidoVo) {
        this.pedidoVo = pedidoVo;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
