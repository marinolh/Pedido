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
@Setter
@Getter
public class UsuarioVo {
    private String id;
    private String nombre;
    private String correo;
    private String clave;
    private String puesto;
}
