/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mp
 */
public class ConexaoBanco {
    private static final String DRIVE = "com.mysql.jdbc.Driver";
    // No final coloque o nome do banco
    private static final String URL ="jdbc:mysql://localhost:3306/ptvtrabalho2";
    private static final String USER ="root";
    private static final String PASS = "1234567890";
   
    
    public  static Connection getConnection() {
      
        try {
            Class.forName(DRIVE);            
       
            return DriverManager.getConnection(URL, USER, PASS);
            
            
        } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Erro na conexão com banco de dados",e);
               
        }
     
        
    }  
    public static void closeConnection(Connection conexao){
        if(conexao != null){        
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    public static void closeConnection(Connection conexao,PreparedStatement stat){
        closeConnection(conexao);
        if(stat != null){        
            try {              
                stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    public static void closeConnection(Connection conexao, PreparedStatement stat,ResultSet rs){
        closeConnection(conexao, stat);
        if(rs != null){        
            try {
              rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    }
    
}
