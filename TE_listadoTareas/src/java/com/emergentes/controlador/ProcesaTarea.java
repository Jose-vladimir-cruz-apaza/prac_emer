package com.emergentes.controlador;
import com.emergentes.Conexion;
import com.emergentes.modelo.Tareas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ProcesaTarea", urlPatterns = {"/ProcesaTarea"})
public class ProcesaTarea extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op"):"lista";
        ArrayList<Tareas> lista= new ArrayList<Tareas>();
        Conexion canal = new Conexion();
        Connection conn = canal.Conectar();
        PreparedStatement ps;
        ResultSet rs;
        System.out.println("llega a servlet");
        if (op.equals("lista")) {
            try{
                String sql = "select * from tareas";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    Tareas ta = new Tareas();
                    ta.setId(rs.getInt("id"));
                    ta.setCompletado(rs.getInt("completado"));
                    ta.setPrioridad(rs.getInt("prioridad"));
                    ta.setTarea(rs.getString("tarea"));
                    lista.add(ta);
                }
                request.setAttribute("tarea", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }catch(SQLException ex){
                System.out.println("Hay problemas con sql en get op=lista"+ex.getMessage());
            }
        }
        if (op.equals("nuevo")) {            
            Tareas l = new Tareas();
            request.setAttribute("tarea1", l);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("editar")) {
            System.out.println("El valor de editar es"+request.getParameter("id"));
            Tareas l = new Tareas();
            l.setId(Integer.parseInt(request.getParameter("id")));
            l.setTarea(request.getParameter("tarea"));
            l.setCompletado(Integer.parseInt(request.getParameter("completado")));
            l.setPrioridad(Integer.parseInt(request.getParameter("prioridad")));
            request.setAttribute("tarea1", l);
            request.getRequestDispatcher("editar.jsp").forward(request, response);

        }
        if (op.equals("eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try{
                String sql = "delete from tareas where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            }catch(SQLException ex){
                System.out.println("Error de sql eliminar"+ex.getMessage());
            }finally{
            canal.desconectar();
            }
            response.sendRedirect("ProcesaTarea");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");
        int prioridad = Integer.parseInt(request.getParameter("prioridad"));
        int completado = Integer.parseInt(request.getParameter("completado"));
        System.out.println("la prioridad"+prioridad);
        System.out.println("completado"+completado);
        Tareas tar = new Tareas();
        tar.setTarea(tarea);
        tar.setCompletado(completado);
        tar.setPrioridad(prioridad);
        Conexion canal = new Conexion();
        Connection conn = canal.Conectar();
        PreparedStatement ps = null;
        ResultSet rs;
        if(id == 0){
            try{
                String sql = "insert into tareas (tarea,prioridad,completado) values (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, tar.getTarea());
                ps.setInt(2, tar.getPrioridad());
                ps.setInt(3, tar.getCompletado());
                ps.executeUpdate();
            }catch(SQLException ex){
                System.out.println("Error al insertar"+ex.getMessage());
            }finally{
                canal.desconectar();
            }
        }
        
        if(id != 0){
            System.out.println("Llega a editar");
            try{
                System.out.println("la tarea es"+tar.getId());
                String sql = "update tareas set tarea = ?, prioridad = ?, completado=? where id = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, tar.getTarea());
                ps.setInt(2, tar.getPrioridad());
                ps.setInt(3, tar.getCompletado());
                ps.setInt(4, id);
                System.out.println("el sql:"+sql);
                ps.executeUpdate();
            }catch(SQLException ex){
                System.out.println("Error al editar"+ex.getMessage());
            }finally{
                canal.desconectar();
            }            
        }
        response.sendRedirect("ProcesaTarea");
    }
}
