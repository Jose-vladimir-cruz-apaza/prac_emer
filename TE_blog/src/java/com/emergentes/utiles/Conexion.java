package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String  driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/bd_blog";
    static String usuario="root";
    static String password="";
    
    protected Connection conn = null;
    
    public Conexion(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error en el driver"+e.getMessage());
        }catch(SQLException e){
            System.out.println("Error en el conectar"+e.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar la base de datos");
        }
    }
    
}
