/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Maxi
 */
public class ConexionJDBC {
    
    public Connection  getConnection() {
       try {
           return DriverManager.getConnection("jdbc:mysql://localhost/fichero_db", "root", "root"); //cadena de conexion...
       } catch (SQLException  e) {
           System.out.println("Error:" + e.getMessage());
           return null;
       }
 
   }
}