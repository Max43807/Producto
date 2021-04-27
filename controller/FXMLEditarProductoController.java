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
import productos.model.domain.Producto;
import productos.model.service.ProductoServiceImpl;
import util.ventanasjfx.DialogoJFX;

/**
 * FXML Controller class
 *
 * @author Maxi
 */
public class FXMLEditarProductoController implements Initializable {



//    @FXML
//    private TextField txfCodigoBarra;
//    @FXML
//    private TextField txfArticulo;
//    @FXML
//    private TextField txfPrecio;
//    @FXML
//    private TextField txfCaducacion;
//    @FXML
//    private TextField txfStock;
//    @FXML
//    private Button btnCancelar;
//    @FXML
//    private Button btnGuardar;
//    
//    ProductoServiceImpl service = new ProductoServiceImpl();
//    Producto aux = new Producto();
//    
//
//    /**
//     * Initializes the controller class.
//     */
@Override
public void initialize(URL url, ResourceBundle rb) {
//        
//    }    
//
//    @FXML
//    private void guardarOnAction(ActionEvent event) {
//        this.txfArticulo.setText(aux.getDescripcion());
//        this.txfCaducacion.setText(aux.getCaducacion());
//        this.txfCodigoBarra.setText(aux.getCodigo());
//        this.txfPrecio.setText(aux.getPrecio());
//        this.txfStock.setText(aux.getStock());
//        
//        
//        Producto p = new Producto();
//        p.setCodigo(txfCodigoBarra.getText().trim());
//        p.setCaducacion(txfCaducacion.getText().trim());
//        p.setPrecio(txfPrecio.getText().trim());
//        p.setStock(txfStock.getText().trim());
//        p.setDescripcion(txfArticulo.getText().trim());
//        
//        service.editar(p);
//        
//        Stage st = (Stage) btnGuardar.getScene().getWindow();
//        st.close();
//        
//    }
//
//    @FXML
//    private void cancelarOnAction(ActionEvent event) {
//        if (DialogoJFX.pedirConfirmacion("¿Desea Continuar'")) {
//            Stage st = (Stage) btnCancelar.getScene().getWindow();
//            st.close();
//        }
//    
  }
}
