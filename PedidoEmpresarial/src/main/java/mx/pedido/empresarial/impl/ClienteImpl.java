/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido.empresarial.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.pedido.empresarial.local.ClienteLocal;
import mx.pedido.empresarial.modelo.Cliente;
import mx.pedido.empresarial.modelo.Usuario;
import mx.pedido.empresarial.modelo.vo.ClienteVo;

/**
 *
 * @author ihsa
 */
@Stateless
public class ClienteImpl extends AbstractPedido<Cliente> implements ClienteLocal {

    @PersistenceContext(unitName = "PedidoEmpresarialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteImpl() {
        super(Cliente.class);
    }

    @Override
    public boolean guardarCliente(String sesion, ClienteVo clienteVo) {
        boolean v = true;
        try {
            Cliente cliente = new Cliente();
            cliente.setRfc(clienteVo.getRfc());
            cliente.setNombre(clienteVo.getNombre());
            cliente.setCodigoReferencia(clienteVo.getRfc().substring(0,4));
            cliente.setDireccion(clienteVo.getDireccion());
            cliente.setTelefono(cliente.getTelefono());
            cliente.setRepresentante(cliente.getRepresentante());
            cliente.setGenero(new Usuario(sesion));
            cliente.setFechaGenero(new Date());
            cliente.setHoraGenero(new Date());
            create(cliente);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al registrar el cliente + + + +  " + e.getMessage());
            v = false;
        }
        return v;
    }

    @Override
    public List traerCliente() {
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from cliente c where c.eliminado = false");
        List<Object[]> lo = em.createNativeQuery(sb.toString()).getResultList();
        List<ClienteVo> listaCliente = null;
        if (lo != null) {
            listaCliente = new ArrayList<ClienteVo>();
            for (Object[] objects : lo) {
                listaCliente.add(castCliente(objects));
            }
        }
        return listaCliente;
    }

    private ClienteVo castCliente(Object object[]) {
        ClienteVo clienteVo = new ClienteVo();
        clienteVo.setNombre((String) object[0]);
        clienteVo.setDireccion((String) object[1]);
        clienteVo.setTelefono((String) object[2]);
        clienteVo.setRepresentante((String) object[3]);
        clienteVo.setCorreo((String) object[4]);
        return clienteVo;
    }

}
