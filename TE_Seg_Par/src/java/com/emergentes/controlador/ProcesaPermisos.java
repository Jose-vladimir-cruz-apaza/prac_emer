package com.emergentes.controlador;
import com.emergentes.dao.PermiososDAO;
import com.emergentes.dao.PermisosDAOimpl;
import com.emergentes.dao.RolesDAO;
import com.emergentes.dao.RolesDAOimpl;
import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOimpl;
import com.emergentes.modelo.Permisos;
import com.emergentes.modelo.Roles;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaPermisos", urlPatterns = {"/ProcesaPermisos"})
public class ProcesaPermisos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               try{
            PermiososDAO dao = new PermisosDAOimpl();
            UsuariosDAO daoUsuario = new UsuariosDAOimpl();
            RolesDAO daoRol = new RolesDAOimpl();
            int id;            
            List<Usuarios> lista_usuarios = null;
            List<Roles> lista_roles = null;           
            Permisos permisos = new Permisos();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = "+ action);
            switch(action){
                case "add":
                    lista_usuarios = daoUsuario.getAll();
                    lista_roles = daoRol.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("permisos",permisos);
                    request.getRequestDispatcher("frmpermisos.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    permisos = dao.getById(id);
                    lista_usuarios = daoUsuario.getAll();
                    lista_roles = daoRol.getAll();
                    request.setAttribute("lista_usuarios", lista_usuarios);
                    request.setAttribute("lista_roles", lista_roles);
                    request.setAttribute("permisos",permisos);
                    request.getRequestDispatcher("frmpermisos.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("PermisoControlador");
                    break;
                case "view":
                    List<Permisos> lista = dao.getAll();
                    request.setAttribute("permisos", lista);
                    request.getRequestDispatcher("permisos.jsp").forward(request, response);
                    break;
            }
        }catch(Exception ex){
            System.out.println("Error fatal " + ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));
        
        Permisos per = new Permisos();
        
        per.setId(id);
        per.setId_usuario(id_usuario);
        per.setId_rol(id_rol);
        
        if(id == 0){
            // Nuevo
            PermiososDAO dao = new PermisosDAOimpl();
            try {
                dao.insert(per);
                response.sendRedirect("ProcesaPermisos");
            } catch (Exception ex) {
                System.out.println("Error post permisos"+ex.getMessage());
            }
        }
        else{
            //Editar
            PermiososDAO dao = new PermisosDAOimpl();
            try {
                dao.update(per);
                response.sendRedirect("ProcesaPermisos");
            } catch (Exception ex) {
                System.out.println("Error Permisos else");
            } 
    }
    }
}
