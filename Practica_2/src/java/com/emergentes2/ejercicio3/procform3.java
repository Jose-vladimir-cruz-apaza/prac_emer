package com.emergentes2.ejercicio3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "procform3", urlPatterns = {"/procform3"})
public class procform3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String nombre = request.getParameter("nombre"); 
            String producto[] = request.getParameterValues("productos"); 
            String existencia =request.getParameter("existencia");
            String precio =request.getParameter("precio");
            
            Productos es = new Productos();
            es.setNombre(nombre);
            es.setProductos(producto);
            es.setExistencia(existencia);
            es.setPrecio(precio);
            
            request.setAttribute("productos", es);
            
            request.getRequestDispatcher("salidaform3.jsp").forward(request, response);            
    
    }
}
