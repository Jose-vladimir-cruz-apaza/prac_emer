package com.emergentes2.practica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "salidaform1", urlPatterns = {"/salidaform1"})
public class salidaform1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        String apellidos=request.getParameter("apellidos");
        String materias[] = request.getParameterValues("materias");
        Materias ma = new Materias();
        ma.setApellido(apellidos);
        ma.setMaterias(materias);
        ma.setNombre(nombre);
         request.setAttribute("materia",ma);
         request.getRequestDispatcher("salidaform1.jsp").forward(request, response);
    }
}
