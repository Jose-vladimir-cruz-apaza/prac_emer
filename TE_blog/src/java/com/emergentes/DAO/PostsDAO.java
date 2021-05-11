package com.emergentes.DAO;

import com.emergentes.modelo.Posts;
import java.util.List;

public interface PostsDAO {
    public void insert(Posts post) throws Exception;
    public void update (Posts post) throws Exception; 
    public void delete (int id) throws Exception;
    public Posts getById(int id) throws Exception;
    public List<Posts> getAll() throws Exception; 
}
