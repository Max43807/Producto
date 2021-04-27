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
import productos.model.domain.Rubro;

/**
 *
 * @author Maxi
 */
public class RubroRepository {
    
    private Connection cn;
    private List<Rubro> rubros;
    
    public RubroRepository() {
        rubros = new ArrayList<>();
        
    }
    
    public List<Rubro> buscarTodo() {
        
        try {
            
            rubros.clear();
            
            cn = new ConexionJDBC().getConnection();
            
            String sql = "select * from rubros";
         
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Rubro rub = new Rubro();
                rub.setId_rubro(rs.getInt("id_rubro"));
                rub.setNombre(rs.getString("nombre"));
                
                rubros.add(rub);
                
            }
            
            cn.close();
            
            return rubros;
            
            } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
