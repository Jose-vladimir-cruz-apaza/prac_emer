package com.emergentes2.ejercicio2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "procform2", urlPatterns = {"/procform2"})
public class procform2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String correo= request.getParameter("correo");
        String contraseña= request.getParameter("contraseña");
        
        Registro re = new Registro();
        
        re.setApellido(apellido);
        re.setNombre(nombre);
        re.setCorreo(correo);
        re.setContraseña(contraseña);
        
        request.setAttribute("registro", re);
        request.getRequestDispatcher("salidaform2.jsp").forward(request, response);                
    }
}
