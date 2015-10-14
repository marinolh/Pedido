/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.registro.consulta;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import mx.pedido.empresarial.impl.EnvioImpl;
import mx.pedido.empresarial.local.ClienteLocal;
import mx.pedido.empresarial.local.PedidoLocal;
import mx.pedido.sesion.Sesion;

/**
 *
 * @author ihsa
 */
@Named(value = "consultaPedidoBean")
@ViewScoped
public class ConsultaPedidoBean {

/**
 * Creates a new instance of ConsultaPedidoBean
 */
public ConsultaPedidoBean() {
}

@EJB
private ClienteLocal clienteLocal;
@EJB
private PedidoLocal pedidoLocal;
@EJB
private EnvioImpl envioImpl;

//
@ManagedProperty(value = "sesion")
private Sesion sesion;

private String numeroPedido;
private List listaPedido;

public void buscar(ActionEvent event) {

}

public List getLista() {
    try {
        listaPedido = envioImpl.traerEstadoPedido(getNumeroPedido());
    } catch (Exception e) {
    }
    return listaPedido;
}

/**
 * @param sesion the sesion to set
 */
public void setSesion(Sesion sesion) {
    this.sesion = sesion;
}

/**
 * @return the numeroPedido
 */
public String getNumeroPedido() {
    return numeroPedido;
}

/**
 * @param numeroPedido the numeroPedido to set
 */
public void setNumeroPedido(String numeroPedido) {
    this.numeroPedido = numeroPedido;
}

/**
 * @param listaPedido the listaPedido to set
 */
public void setListaPedido(List listaPedido) {
    this.listaPedido = listaPedido;
}

}
