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
import productos.model.domain.Proveedor;

/**
 *
 * @author Maxi
 */
public class ProveedorRepository {
    
    private Connection cn;
    private List<Proveedor> proveedores;
    
    public ProveedorRepository() {
        proveedores = new ArrayList<>();
        
    }
    
    public List<Proveedor> buscarTodo() {
        
        try{
            
            proveedores.clear();
            
            cn = new ConexionJDBC().getConnection();
            
            String sql = "select * from proveedores";
            
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Proveedor prov = new Proveedor();
                prov.setId_proveedor(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setDireccion(rs.getString("dir"));
                prov.setTelefono(rs.getString("tel"));
                prov.setEmail(rs.getString("mail"));
                
                proveedores.add(prov);
                
            }
            
            cn.close();
            
            return proveedores;
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }    
        
    }
}
