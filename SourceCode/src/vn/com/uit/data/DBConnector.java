/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.uit.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc DV
 */
public class DBConnector {
    
    private static Connection conn;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EnglishTrainingCenter;user=sa;password=12345");    
        } catch (ClassNotFoundException | SQLException ex) {
            conn = null;
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
