package com.emergentes.DAO;
import com.emergentes.utiles.Conexion;
import com.emergentes.modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UsuarioDAOimp extends Conexion implements UsuariosDAO{

    @Override
    public int VerificarUsuario(Usuarios us) throws Exception {
        int a=0;
        try {
            this.conectar();
            String sql = "select * from usuarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(us.getUsuario().equals(rs.getString("usuario")  )){
                    if (us.getPassword().equals(rs.getString("PASSWORD"))) {
                        a=1;
                    }
                }
            }            
        } catch (Exception e) {
            System.out.println("Error en verifiacr usuario"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return a;
    }   
}
