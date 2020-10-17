/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_prj_av2;


import Dao.ConexaoBanco;
import View.JanelaPrincipal;
import java.sql.Connection;

/**
 *
 * @author mp
 */
public class Trabalho_PRJ_Av2 {

  
    public static void main(String[] args) {
  
        JanelaPrincipal janelaPrincipal = new JanelaPrincipal(null,true);
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setVisible(true);
        
    }
   
}
/*      //teste de conexão
        Connection conexao = null;
        conexao =   ConexaoBanco.getConnection();
        if(conexao != null){
            System.out.println("conectou");
        
        }else{
            System.out.println("não conectou");
        }*/