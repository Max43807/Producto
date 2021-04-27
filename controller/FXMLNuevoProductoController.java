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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import productos.model.service.ProductoServiceImpl;
import productos.model.domain.Producto;
import util.ventanasjfx.DialogoJFX;

/**
 * FXML Controller class
 *
 * @author Maxi
 */
public class FXMLNuevoProductoController implements Initializable {

    @FXML
    private TextField txfCodigoBarra;
    @FXML
    private TextField txfArticulo;
    @FXML
    private TextField txfPrecio;
    @FXML
    private TextField txfCaducacion;
    @FXML
    private TextField txfStock;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    
    ProductoServiceImpl service = new ProductoServiceImpl();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void guardarOnAction(ActionEvent event) {
        
        Producto c = new Producto();
        c.setCodigo(txfCodigoBarra.getText().trim());
        c.setCaducacion(txfCaducacion.getText().trim());
        c.setPrecio(txfPrecio.getText().trim());
        c.setStock(txfStock.getText().trim());
        c.setDescripcion(txfArticulo.getText().trim());
        
        service.guardar(c);
        
        Stage st = (Stage) btnAceptar.getScene().getWindow();
        st.close();
    }

    @FXML
    private void cancelarOnAction(ActionEvent event) {
        if (DialogoJFX.pedirConfirmacion("¿Desea Continuar'")) {
            Stage st = (Stage) btnCancelar.getScene().getWindow();
            st.close();
        }   
    
    }
}