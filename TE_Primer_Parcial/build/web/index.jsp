<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Vacunas"%>
<%@page import="java.util.ArrayList"%>
<%
    if(session.getAttribute("vacunas") == null){
        ArrayList<Vacunas> pro = new ArrayList<Vacunas>();
        session.setAttribute("vacunas", pro);
    }
    System.out.println("llega la lista");
    ArrayList<Vacunas> pr = (ArrayList<Vacunas>) session.getAttribute("vacunas");
    String vacu[];
    Vacunas va = new Vacunas();
    
    request.setAttribute("listados", pr);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vacunas_JoseCruz</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>PRIMER PARCIAL TEM-742</th>
            </tr>
                <th>Nombre: Jose Vladimir Cruz Apaza</th>
            <tr>
                <th>Carnet: 6077153 L.P.</th>
            </tr>
        </table>   
        <h1>Registro de vacunas</h1>
        <a href="ProcesaVacunas?op=nuevo">Nuevo</a>
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Nombre</td>
                <td>Peso</td>
                <td>Talla</td>
                <td>Vacuna</td>
            </tr>
   
            <%  
            if (pr != null) {
                for(Vacunas item:pr)
                {
            %>           
            <tr>
   
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getPeso() %></td>
                <td><%= item.getTalla() %></td>
                <td><%= item.getVacuna() %></td>
                <td><a href="ProcesaVacunas?op=modificar&id=<%= item.getId() %>">Modificar</a></td>
                <td><a href="ProcesaVacunas?op=eliminar&id=<%= item.getId() %>" onclick="return(confirm('Desea Eliminar?'))">Eliminar</a></td>
             </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
