package com.emergentes.controlador;
import com.emergentes.DAO.UsuarioDAOimp;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaUsuario", urlPatterns = {"/ProcesaUsuario"})
public class ProcesaUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a;
        UsuarioDAOimp dao = new UsuarioDAOimp();
        Usuarios us = new Usuarios();
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        us.setUsuario(usuario);
        us.setPassword(password);
        try {
           a=dao.VerificarUsuario(us);
            if (a==1) {
            response.sendRedirect("ProcesaPosts");    
            }else{
            response.sendRedirect("index.jsp");
            }  
        } catch (Exception e) {
            System.out.println("Error en ingreso");
        }
        
    }
}
