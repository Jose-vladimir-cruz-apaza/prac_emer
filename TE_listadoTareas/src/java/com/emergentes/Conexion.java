package com.emergentes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String url = "jdbc:mysql://localhost:3306/bd_proyectos";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
    public Conexion(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, usuario,password);
            if (conn != null) {
                System.out.println("Conexion ok"+ conn);
            }
        }
        catch(SQLException ex){
            System.out.println("Error de sql: "+ ex.getMessage()); 
        }catch(ClassNotFoundException ex){
            //si ocurre un error con el driver salta este error
            System.out.println("Falta driver"+ex.getMessage());
        }        
    }
    public Connection Conectar(){
        return conn;
    }
    public void desconectar(){
        System.out.println("Cerrando la conexion"+conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error de sql"+ex.getMessage());
        }
    }
}
