package com.emergentes.dao;

import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOimpl extends ConexionDB implements UsuariosDAO{

    @Override
    public void insert(Usuarios usuario) throws Exception {
        try {
            this.conectar();
            String sql = "insert into usuarios(usuario,correo,clave) values(?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getCorreo());
            ps.setString(3,usuario.getClave());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar usuarios");
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Usuarios usuario) throws Exception {
        try {
            this.conectar();
            String sql = "update usuarios set usuario=?, correo=?, clave=? where id=? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getCorreo());
            ps.setString(3,usuario.getClave());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al update usuarios");
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from usuarios where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar usuarios");
        }finally{
            this.desconectar();
        }
    }

    @Override
    public Usuarios getById(int id) throws Exception {
        Usuarios cli = new Usuarios();
        try {
            this.conectar();
            String sql = "select * from usuarios where id = ?  ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            cli.setId(rs.getInt("id"));
            cli.setUsuario(rs.getString("usuario"));
            cli.setCorreo(rs.getString("correo"));
            cli.setClave(rs.getString("clave"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id");
        }finally{
            this.desconectar();
        }return cli;
    }

    @Override
    public List<Usuarios> getAll() throws Exception {
        List<Usuarios> lista = null; 
        try {
            this.conectar();
            String sql = "select id,usuario,correo,md5(clave) as clave from usuarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Usuarios>(); 
            while(rs.next()){
            Usuarios us = new Usuarios();    
            us.setId(rs.getInt("id"));
            us.setUsuario(rs.getString("usuario"));
            us.setCorreo(rs.getString("correo"));
            us.setClave(rs.getString("clave"));
            lista.add(us);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en el select en usuarios"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}
