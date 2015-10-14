/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.pedido;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.pedido.empresarial.local.UsuarioLocal;
import mx.pedido.empresarial.modelo.vo.UsuarioVo;
import mx.pedido.sesion.Sesion;

/**
 *
 * @author ihsa
 */
@WebServlet(name = "Login", urlPatterns = {"/Rastreo"})
public class Login extends HttpServlet {

    @EJB
    private UsuarioLocal usuarioLocal;
    @ManagedProperty(name = "sesion", value = "sesion")
    private Sesion sesion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
        //   PrintWriter out = response.getWriter();

        String user = request.getParameter("usaurio1");
        String pass = request.getParameter("clave1");

        if (validaUsuario(user, pass)) {
            System.out.println("user: " + user);
            System.out.println("pass: " + pass);
            RequestDispatcher rs = request.getRequestDispatcher("/vista/sistema/registroPedido.xhtml");
            rs.forward(request, response);
        } else {
            //  out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("principal.xhtml");
            rs.include(request, response);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  throw new IOException("LoginServlet no acepta peticiones GET");
        try {
            processRequest(request, response);
        } catch (Exception e) {
//          e.printStackTrace();
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            //     e.printStackTrace();
            throw new IOException(e.getMessage());
        }
    }

    private boolean validaUsuario(String user, String pass) {
        UsuarioVo uv = usuarioLocal.buscarPorId(user);
        boolean v = false;
        if (uv != null) {
            try {
                if (uv.getClave().equals(usuarioLocal.encriptar(pass))) {
                    sesion.setUsuarioVo(uv);
                    v = true;
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return v;
    }

    /**
     * @param sesion the sesion to set
     */
    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

}
