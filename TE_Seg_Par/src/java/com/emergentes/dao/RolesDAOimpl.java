package com.emergentes.dao;

import com.emergentes.modelo.Roles;
import com.emergentes.modelo.Usuarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolesDAOimpl extends ConexionDB implements RolesDAO{
    @Override
    public void insert(Roles roles) throws Exception {
        try {
            this.conectar();
            String sql = "insert into roles(descripcion) values(?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, roles.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar roles"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Roles roles) throws Exception {
        try {
            this.conectar();
            String sql = "update roles set descripcion=? where id=? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,roles.getDescripcion());
            ps.setInt(2, roles.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al update roles"+e.getMessage());
        }finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from roles where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar roles"+e.getMessage());
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Roles getById(int id) throws Exception {
        Roles ro = new Roles();
        try {
            this.conectar();
            String sql = "select * from roles where id = ? ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            ro.setId(rs.getInt("id"));
            ro.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error en el by id roles"+e.getMessage());
        }finally{
            this.desconectar();
        }return ro;
    }

    @Override
    public List<Roles> getAll() throws Exception {
        List<Roles> lista = null; 
        try {
            this.conectar();
            String sql = "select * from roles";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Roles>(); 
            while(rs.next()){
            Roles ro = new Roles();    
            ro.setId(rs.getInt("id"));
            ro.setDescripcion(rs.getString("Descripcion"));
            lista.add(ro);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en el select en Roles"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return lista;
    }

}
