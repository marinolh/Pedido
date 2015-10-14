/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.modelo.vo;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ihsa
 */
@Getter
@Setter
public class EnvioVo {
    private int id;
    private String numero;
    private String factura;
    private String pedido;
    private Date FechaEnvio;
    private Date horaSalida;
    private String estado;
    private List<DetalleEnvioVo> listaDetalle;
}
