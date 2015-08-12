/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo.vo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ihsa
 */
@Getter
@Setter
public class ClienteVo {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String representante;
    private String correo;
}
