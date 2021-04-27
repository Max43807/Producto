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
import productos.model.repository.MarcaRepository;
import productos.model.repository.ProductoRepository;
import productos.model.repository.ProveedorRepository;
import productos.model.repository.RubroRepository;

/**
 *
 * @author Maxi
 */
public class ProductoServiceImpl implements IProductoService{
    
    ProductoRepository repo = new ProductoRepository();
    MarcaRepository marRepo = new MarcaRepository();
    ProveedorRepository proRepo = new ProveedorRepository();
    RubroRepository rubRepo = new RubroRepository();

    @Override
    public List<Producto> buscarTodo() {
        return repo.buscarTodo();
    }

    @Override
    public List<Producto> buscarPor(String criterio) {
        return repo.buscarPor(criterio);
    }

    @Override
    public void guardar(Producto producto) {
        repo.guardar(producto);
    }

    @Override
    public void borrar(int id) {
        repo.borrar(id);
    }

    @Override
    public List<Proveedor> getProveedores() {
        return proRepo.buscarTodo();
    }

    @Override
    public List<Rubro> getRubros() {
        return rubRepo.buscarTodo();
    }

    @Override
    public List<Marca> getMarcas() {
        return marRepo.buscarTodo();
    }

    @Override
    public void editar(Producto producto) {
        repo.editar(producto);
    }
    
}
