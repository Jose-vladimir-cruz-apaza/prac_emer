package com.emergentes.DAO;

import com.emergentes.modelo.Posts;
import com.emergentes.utiles.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostsDAOimp extends Conexion implements PostsDAO{
    @Override
    public void insert(Posts post) throws Exception {
        try {
            this.conectar();
            String sql = "insert into posts (fecha,titulo,contenido) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.executeUpdate();    
        } catch (Exception e) {
            System.out.println("Error en insertar"+e.getMessage());
        }finally{
            this.desconectar();
        }                
    }
    @Override
    public void update(Posts post) throws Exception {
        try {
            this.conectar();
            String sql = "update posts set fecha = ?, titulo = ?, contenido =? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.setInt(4,post.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en update"+e.getMessage());
        }finally{
            this.desconectar();
        }
    }
    @Override
    public void delete(int id) throws Exception {
            try {
            this.conectar();
            String sql = "delete from posts where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
                System.out.println("Error en delete"+e.getMessage());
        }finally{
                this.desconectar();
            }           
    }
    @Override
    public Posts getById(int id) throws Exception {
        Posts post = new Posts();
        try {
            this.conectar();
            String sql = "select * from posts where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setContenido(rs.getString("contenido"));
                post.setTitulo(rs.getString("titulo"));
                post.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            System.out.println("Error en obtener columna"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return post;
    }
    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista = null;
        try {            
            this.conectar();
            String sql = "select * from posts ORDER BY fecha desc";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Posts>();
            while(rs.next()){
                Posts post = new Posts();
                post.setId(rs.getInt("id"));
                post.setContenido(rs.getString("contenido"));
                post.setFecha(rs.getString("fecha"));
                post.setTitulo(rs.getString("titulo"));
                lista.add(post);                
            }
        } catch (Exception e) {
            System.out.println("Error en select"+e.getMessage());
        }finally{
            this.desconectar();
        }
        return lista;
    }
}
