/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ihsa
 */
@Getter
@Setter
public class PedidoVo implements Serializable {

    private String numero;
    private String codigo;
    private double total;
    private double subtotal;
    private double impuesto;
    private int idMoneda;
    private String moneda;
    private String observacion;
    private ClienteVo clienteVo = new ClienteVo();
    private Date fechaSalida;
    private Date horaSalida;

}
