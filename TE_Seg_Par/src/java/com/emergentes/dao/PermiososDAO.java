package com.emergentes.dao;

import com.emergentes.modelo.Permisos;
import java.util.List;

public interface PermiososDAO {
    public void insert(Permisos permiso) throws Exception;
    public void update(Permisos permiso) throws Exception;
    public void delete(int id) throws Exception;
    public Permisos getById(int id) throws Exception;
    public List<Permisos> getAll() throws Exception;
}
