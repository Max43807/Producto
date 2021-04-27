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
import productos.model.domain.Producto;
import productos.model.domain.Rubro;

/**
 *
 * @author Maxi
 */
public class ProductoRepository {
    
    private Connection cn;
    private List<Producto> productos;
    
    public ProductoRepository() {
        productos = new ArrayList<>();
        
    }
    
    public List<Producto> buscarTodo() {
        
        try {
            
            productos.clear();
            
            cn = new ConexionJDBC().getConnection();
//            String sql = "select p.codigo_barra,p.descrip," +
//                            " r.nombre, p.precio, p.fecha_vencimiento, " +
//                            " p.stock, concat(pr.nombre,' - ', pr.dir,' - ', pr.tel,' - ', pr.mail)" +
//                            " from productos p inner join marcas m on p.id_marca = m.id_marca" +
//                            " inner join rubros r on p.id_rubro = r.id_rubro" +
//                            " inner join proveedores pr on p.id_proveedor = pr.id_proveedor;";
            String sql = "select * from productos";
            
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId_producto(rs.getInt("id_producto"));
                pro.setCodigo(rs.getString("codigo_barra"));
                pro.setCaducacion(rs.getString("fecha_vencimiento"));
                pro.setPrecio(rs.getString("precio"));
                pro.setStock(rs.getString("stock"));
                pro.setDescripcion(rs.getString("descrip"));
                
                
                
                
                
                productos.add(pro);
            }
            
            cn.close();
            
            return productos;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
    public List<Producto> buscarPor(String criterio) {
        
        try {
            
            productos.clear();
            
            cn = new ConexionJDBC().getConnection();
//            String sql = "select p.codigo_barra as 'Codigo de Fabricante',p.descrip as 'Articulo'," +
//                        "r.nombre as 'Categoria', p.precio as 'Precio', p.fecha_vencimiento as 'Caducacion', " +
//                        "p.stock as 'Disponibilidad', concat(pr.nombre,' - ', pr.dir,' - ', pr.tel,' - ', pr.mail) as 'Proveedor'" +
//                        "from productos p inner join marcas m on p.id_marca = m.id_marca" +
//                        "inner join rubros r on p.id_rubro = r.id_rubro" +
//                        "inner join proveedores pr on p.id_proveedor = pr.id_proveedor" +
//                        "where p.descrip like '%" + criterio + "%'" +
//                        "or r.nombre like '%" + criterio + "%'";
                String sql = " select * from productos" +
                             " where descrip like '%" + criterio + "%'";
            
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto pro = new Producto();
                //pro.setId_producto(rs.getInt("id_producto"));
                pro.setCodigo(rs.getString("codigo_barra"));
                pro.setCaducacion(rs.getString("fecha_vencimiento"));
                pro.setPrecio(rs.getString("precio"));
                pro.setStock(rs.getString("stock"));
                pro.setDescripcion(rs.getString("descrip"));
                
                productos.add(pro);
                
            }
            
            cn.close();
            return productos;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }    
    }
    
    public void guardar(Producto producto) {
        
        try {
            
            cn = new ConexionJDBC().getConnection();
            
            String insert = "insert into productos(codigo_barra, fecha_vencimiento, precio, stock, descrip, id_marca, id_rubro, id_proveedor) values (?, ?, ?, ?, ?, 1, 1, 1)";
            
            PreparedStatement ps = cn.prepareStatement(insert);
            
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getCaducacion());
            ps.setString(3, producto.getPrecio());
            ps.setString(4, producto.getStock());
            ps.setString(5, producto.getDescripcion());
            
            ps.execute();
            
            cn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void borrar(int id) {
        
        try{
            
            cn = new ConexionJDBC().getConnection();
            
            String delete = "delete from productos where id_producto =?";
            
            PreparedStatement ps = cn.prepareStatement(delete);
            
            ps.setInt(1, id);
            
            ps.execute();
            
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }    
    }
    
    public void editar(Producto producto) {
        
        try{
            
            cn = new ConexionJDBC().getConnection();
            
            String update = "update into productos(codigo_barra, fecha_vencimiento, precio, stock, descrip, id_marca, id_rubro, id_proveedor) values (?, ?, ?, ?, ?, 1, 1, 1)";
            
            PreparedStatement ps = cn.prepareStatement(update);
            
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getCaducacion());
            ps.setString(3, producto.getPrecio());
            ps.setString(4, producto.getStock());
            ps.setString(5, producto.getDescripcion());
            
            ps.execute();
            
            cn.close();
            
                    
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
