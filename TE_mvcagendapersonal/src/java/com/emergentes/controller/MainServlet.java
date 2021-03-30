package com.emergentes.controller;
import com.emergentes.modelo.Notas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
        Notas objage = new Notas();
        int id,pos;
        HttpSession se = request.getSession();
        List<Notas> lista = (List<Notas>)se.getAttribute("agenda");
        switch (opcion) {
            case "nuevo":
                request.setAttribute("objagenda", objage);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                objage = lista.get(pos);
                request.setAttribute("objagenda", objage);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                request.setAttribute("agenda", lista);
                response.sendRedirect("index.jsp");
                break;                        
            default:
                request.setAttribute("agenda", lista);
                response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Notas> lista = (ArrayList<Notas>) ses.getAttribute("agenda");
        Notas objper = new Notas();
        objper.setId(id);
        objper.setHora(request.getParameter("hora"));
        objper.setActividad(request.getParameter("actividad"));
        objper.setCompletado((request.getParameter("completado")));
        System.out.println("El ID es "+id);
        if( id == 0){
            int idNuevo = ObtenerId(request);
            objper.setId(idNuevo);           
            lista.add(objper);
            System.out.println("llega: "+idNuevo);
            System.out.println(objper.toString());
  
        } else{
            int pos = buscarPorIndice(request,id);  
            lista.set(pos, objper);
            System.out.println(objper.toString());
        }
        System.out.println("Enviando as Index");
        request.setAttribute("agenda", lista);
        response.sendRedirect("index.jsp");
        
    }
    public int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        List<Notas> lista = (List<Notas>) ses.getAttribute("agenda");

        int pos = -1;

        if (lista != null) {
            for (Notas ele : lista) {
                ++pos;
                if (ele.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }

    public int ObtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<Notas> lista = (ArrayList<Notas>) ses.getAttribute("agenda");
        int idn = 0;
        for (Notas ele : lista) {
            idn = ele.getId();
        }
        return idn + 1;
    }
}
