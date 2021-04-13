package com.emergentes.controlador;
import com.emergentes.modelo.Productos;
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
@WebServlet(name = "ProcesaProductos", urlPatterns = {"/ProcesaProductos"})
public class ProcesaProductos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String opcion = request.getParameter("op");
        Productos objpro = new Productos();
        int id, pos;
        HttpSession ses = request.getSession();
        List<Productos> lista = (List<Productos>) ses.getAttribute("producto");
        switch(opcion){
            case"nuevo":
                request.setAttribute("miobjpro", objpro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case"modificar":
                id = Integer.parseInt(request.getParameter("id"));
                pos =   buscarPorIndice(request,id);
                objpro = lista.get(pos);
                request.setAttribute("miobjpro", objpro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case"eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                if (pos>=0) {
                    lista.remove(pos);
                }
                request.setAttribute("producto", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
                request.setAttribute("producto", lista);
                response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            ArrayList<Productos> lista= (ArrayList<Productos>) ses.getAttribute("producto");
            Productos objpro = new Productos();
            objpro.setId(id);
            objpro.setProducto(request.getParameter("productos"));
            objpro.setPrecio(Double.parseDouble(request.getParameter("precio")));
            objpro.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
            if (id == 0) {
                int idNuevo = obtenerId(request);
                objpro.setId(idNuevo);
                lista.add(objpro);    
            }else{
                int pos = buscarPorIndice(request, id);
                lista.set(pos, objpro);
                
            }
            System.out.println("Manda datos");
            request.setAttribute("producto", lista);
            response.sendRedirect("index.jsp");
    } 
    public int buscarPorIndice(HttpServletRequest request, int id){
    HttpSession ses = request.getSession();
    List<Productos> lista = (List<Productos>) ses.getAttribute("producto");
    int pos = -1;
        if (lista != null) {
            for (Productos ele : lista) {
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
        ArrayList<Productos> lista = (ArrayList<Productos>) ses.getAttribute("producto");
        int idn = 0;
        for (Productos item:lista) {
            idn = item.getId();
        }
        return idn +1;
    }
}

