package com.emergentes2.ejercicio4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProclLibros", urlPatterns = {"/ProclLibros"})
public class ProclLibros extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Libros li = new Libros();
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String resumen = request.getParameter("resumen");
        String medio[] = request.getParameterValues("medio");
        li.setTitulo(titulo);
        li.setAutor(autor);
        li.setResumen(resumen);
        li.setMedio(medio);
        request.setAttribute("libros", li);
        request.getRequestDispatcher("salidaform4.jsp").forward(request, response);
    }
}
