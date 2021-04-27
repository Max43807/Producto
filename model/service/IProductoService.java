/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.model.service;

import java.util.List;
import productos.model.domain.Marca;
import productos.model.domain.Producto;
import productos.model.domain.Proveedor;
import productos.model.domain.Rubro;

/**
 *
 * @author Maxi
 */
public interface IProductoService {
    
    public List<Producto> buscarTodo();
    
    public List<Producto> buscarPor(String criterio);
    
    public void guardar(Producto producto);
    
    public void borrar(int id);
    
    public void editar(Producto producto);
    
    public List<Proveedor> getProveedores();
    
    public List<Rubro> getRubros();
    
    public List<Marca> getMarcas();
}
