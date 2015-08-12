/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo.vo;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ihsa
 */
@Getter
@Setter
public class PedidoVo implements Serializable{
    private String numero;
    private double total;
    private double subtotal;
    private double  impuesto;
    private int idMoneda;
    private String moneda;
    private int cliente;
    private String nombreCliente;
    private String observacion;
}
