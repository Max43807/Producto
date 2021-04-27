/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import productos.jdbc.ConexionJDBC;
import productos.model.domain.Marca;

/**
 *
 * @author Maxi
 */
public class MarcaRepository {
    
    private Connection cn;
    private List<Marca> marcas;
    
    public MarcaRepository() {
        marcas = new ArrayList<>();
        
    }
    
    public List<Marca> buscarTodo() {
        
        try{
            
            marcas.clear();
            
            cn = new ConexionJDBC().getConnection();
            
            String sql = "select * from marcas";
            
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Marca mar = new Marca();
                mar.setId_marca(rs.getInt("id_marca"));
                mar.setNombre(rs.getString("nombre"));
                
                marcas.add(mar);
            }
            
            cn.close();
            
            return marcas;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
