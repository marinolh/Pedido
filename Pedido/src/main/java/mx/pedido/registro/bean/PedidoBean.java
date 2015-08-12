/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.registro.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import mx.pedido.empresarial.modelo.Cliente;
import mx.pedido.empresarial.modelo.vo.ClienteVo;
import mx.pedido.empresarial.modelo.vo.PedidoVo;

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
    private PedidoVo pedidoVo;
    private String cliente;

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
}
