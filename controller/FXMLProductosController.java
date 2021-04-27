/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import productos.model.domain.Producto;
import productos.model.service.ProductoServiceImpl;
import util.ventanasjfx.DialogoJFX;

/**
 *
 * @author Maxi
 */
public class FXMLProductosController implements Initializable {

    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnEditar;
    @FXML
    private TextField txfBuscar;
    @FXML
    private TableView<Producto> tbvProductos;
    
    Producto pro = new Producto();
    ProductoServiceImpl service = new ProductoServiceImpl();
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatos();
    }

    public void cargarDatos() {
        //recargar datos
        tbvProductos.getItems().clear();
        tbvProductos.getItems().addAll(service.buscarTodo());
    }

    @FXML
    private void nuevo_OnAction(ActionEvent event) {
        DialogoJFX.abrir(btnNuevo.getScene().getWindow(), "/productos/view/FXMLNuevoProducto", "Nuevo Producto");
        cargarDatos();
    }

    @FXML
    private void borrar_OnAction(ActionEvent event) {

        if (tbvProductos.getSelectionModel().getSelectedItems().size() == 0) {
            DialogoJFX.mostrarError("Hay que seleccionar un contacto para borrar");
            return;
        }

        if (DialogoJFX.pedirConfirmacion("¿Seguro que quiere borrar este producto \n" + pro.getDescripcion() + " ?")) {
            service.borrar(tbvProductos.getSelectionModel().getSelectedItem().getId_producto());
            cargarDatos();
        }

    }

    @FXML
    private void editar_OnAction(ActionEvent event) {

//       if (tbvProductos.getSelectionModel().getSelectedItems().size() == 0) {
//            DialogoJFX.mostrarError("Hay que seleccionar un contacto para editar");
//            return;
//       }
//            service.editar(tbvProductos.getSelectionModel().getSelectedItem());
//            DialogoJFX.abrir(btnNuevo.getScene().getWindow(), "/productos/view/FXMLEditarProducto", "Nuevo Producto");
//        cargarDatos();
    }

    @FXML
    private void buscar_OnKeyTyped(KeyEvent event) {
        tbvProductos.getItems().clear();
        tbvProductos.getItems().addAll(service.buscarPor(txfBuscar.getText()));
    }

}
