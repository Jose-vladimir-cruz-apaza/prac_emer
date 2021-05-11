package com.emergentes.controlador;

import com.emergentes.DAO.PostsDAO;
import com.emergentes.DAO.PostsDAOimp;
import com.emergentes.modelo.Posts;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaPosts", urlPatterns = {"/ProcesaPosts"})
public class ProcesaPosts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PostsDAO dao = new PostsDAOimp();
            int id;
            Posts post = new Posts();
            String action = (request.getParameter("action") != null)? request.getParameter("action") :  "show";
            switch (action){
                case "add":
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    post = dao.getById(id);
                    request.setAttribute("post", post);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                   response.sendRedirect("ProcesaPosts");
                    break; 
                default:
                    List<Posts> lista = dao.getAll();
                    request.setAttribute("blogs", lista);
                    request.getRequestDispatcher("blog.jsp").forward(request, response);
                break;    
            }
                    
        } catch (Exception e) {
            System.out.println("Error en get"+e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PostsDAO dao = new PostsDAOimp();
        int id = Integer.parseInt(request.getParameter("id"));
        String contenido = request.getParameter("contenido");
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        
        Posts post = new Posts();
        post.setId(id);
        post.setContenido(contenido);
        post.setFecha(fecha);
        post.setTitulo(titulo);
        if (id == 0) {
            System.out.println("llega el id = 0");
            try {
                dao.insert(post);
                response.sendRedirect("ProcesaPosts");
            } catch (Exception e) {
                System.out.println("Error en post id =0:"+e.getMessage());
            }
        }else{
            try {
                dao.update(post);
                response.sendRedirect("ProcesaPosts");
            } catch (Exception e) {
                System.out.println("Error en post id =1:"+e.getMessage());
            }
        }
    }
}
