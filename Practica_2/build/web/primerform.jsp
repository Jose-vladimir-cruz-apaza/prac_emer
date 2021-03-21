<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Inscripcion del curso</h1>
        <form action="salidaform1" method="post" align="center">
            <label>Nombre</label> 
            <input type="text" name="nombre" required/>
            <br>
            <br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" required/>
            <br>
            <br>
            <label>Curso</label>
            <select name="materias">
                <option value="Base de datos II">Base de datos II</option>
                <option value="Emergentes II">Emergentes II</option>
                <option value="Redes 2">Redes 2</option>
                <option value="Analisis y diseño">Analisis y diseño</option>
                <option value="Inteligencia artificial">Inteligencia artificial</option>
            </select>  
            <br>
            <br>
            <input type="submit" value="Envia">
        </form>
    </body>
</html>
