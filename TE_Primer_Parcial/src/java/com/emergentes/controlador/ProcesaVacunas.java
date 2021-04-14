package com.emergentes.controlador;
import com.emergentes.modelo.Vacunas;
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
@WebServlet(name = "ProcesaVacunas", urlPatterns = {"/ProcesaVacunas"})
public class ProcesaVacunas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {       
        String opcion = request.getParameter("op");
        Vacunas objpro = new Vacunas();
        int id, pos;
        HttpSession ses = request.getSession();
        List<Vacunas> lista = (List<Vacunas>) ses.getAttribute("vacunas");        
        switch(opcion){
            case"nuevo":
                request.setAttribute("miobjvac", objpro);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                break;
            case"modificar":
                id = Integer.parseInt(request.getParameter("id"));
                pos =   buscarPorIndice(request,id);
                objpro = lista.get(pos);
                request.setAttribute("miobjvac", objpro);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
                break;
            case"eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                if (pos>=0) {
                    lista.remove(pos);
                }
                request.setAttribute("vacunas", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
                request.setAttribute("vacunas", lista);
                response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            ArrayList<Vacunas> lista= (ArrayList<Vacunas>) ses.getAttribute("vacunas");
            Vacunas objpro = new Vacunas();
            objpro.setId(id);
            objpro.setNombre(request.getParameter("nombre"));
            objpro.setPeso(request.getParameter("peso"));
            objpro.setTalla(request.getParameter("talla"));
            objpro.setVacuna(request.getParameter("vacuna"));
            if (id == 0) {
                System.out.println("llega con id 0");
                int idNuevo = obtenerId(request);
                objpro.setId(idNuevo);
                lista.add(objpro);    
            }else{
                int pos = buscarPorIndice(request, id);
                lista.set(pos, objpro);
                
            }
            System.out.println("Manda datos");
            request.setAttribute("vacunas", lista);
            response.sendRedirect("index.jsp");
    } 
    public int buscarPorIndice(HttpServletRequest request, int id){
    HttpSession ses = request.getSession();
    List<Vacunas> lista = (List<Vacunas>) ses.getAttribute("vacunas");
    int pos = -1;
        if (lista != null) {
            for (Vacunas ele : lista) {
                ++pos;
                if (ele.getId() == id) {
                    break;
                }
            }
        }
    return pos;
    }
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Vacunas> lista = (ArrayList<Vacunas>) ses.getAttribute("vacunas");
        int idn = 0;
        for (Vacunas item:lista) {
            idn = item.getId();
        }
        return idn +1;
    }
}
