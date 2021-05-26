package com.emergentes.dao;

import com.emergentes.modelo.Permisos;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PermisosDAOimpl extends ConexionDB implements PermiososDAO{

    @Override
    public void insert(Permisos permiso) throws Exception {
        try {
            this.conectar();
            String sql = "insert into permisos (id_usuario, id_rol) values (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, permiso.getId_usuario());
            ps.setInt(2, permiso.getId_rol());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update permisos"+e.getMessage());;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Permisos permiso) throws Exception {
        try {
            this.conectar();
            String sql = "update permisos SET id_usuario = ?, id_rol = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, permiso.getId_usuario());
            ps.setInt(2, permiso.getId_rol());
            ps.setInt(3, permiso.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update permisos"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
         try {
            this.conectar();
            String sql = "delete from permisos where id = ? ";
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
    public Permisos getById(int id) throws Exception {
        Permisos p = new Permisos();
        try {
            this.conectar();
            String sql = "select * from permisos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setId_usuario(rs.getInt("id_usuario"));
                p.setId_rol(rs.getInt("id_rol"));
            }

        } catch (Exception e) {
            System.out.println("Error en el by id permisos: "+e.getMessage());
        } finally {
            this.desconectar();
        }
        return p;
    }

    @Override
    public List<Permisos> getAll() throws Exception {
        List<Permisos> lista = null;
        try {
            this.conectar();
            String sql = "SELECT p.*,u.usuario AS 'USUARIO', r.descripcion AS 'ROL' FROM permisos p  ";
            sql += "LEFT JOIN usuarios u  ON p.id_usuario = u.id  ";
            sql += "LEFT JOIN roles r  ON p.id_rol = r.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Permisos>();
            while (rs.next()) {
                Permisos permisos = new Permisos();
                permisos.setId(rs.getInt("id"));
                permisos.setId_usuario(rs.getInt("id_usuario"));
                permisos.setId_rol(rs.getInt("id_rol"));
                permisos.setUsuario(rs.getString("usuario"));
                permisos.setDescripcion(rs.getString("rol"));
                lista.add(permisos);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en get all permisos"+e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
