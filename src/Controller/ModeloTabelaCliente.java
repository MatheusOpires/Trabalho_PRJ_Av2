/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mp
 */
public class ModeloTabelaCliente extends AbstractTableModel{
    
    private static final int COLUNA_NOME = 0;
    private static final int COLUNA_EMAIL = 1;
    private static final int COLUNA_TELEFONE = 2;
    private static final int COLUNA_RUA = 3;
    private static final int COLUNA_BAIRRO = 4;
    private static final int COLUNA_CIDADE = 5;
    private static final int COLUNA_ESTADO = 6;
    private static final int COLUNA_NUMERO = 7;
    private static final int COLUNA_COMPLEMENTO = 8;
    
    
    private String[] colunas = new String[]{"Nome","Email","Telefone","Rua","Bairro","Cidade"
    ,"Estado","numero","Complemento"};
    private ArrayList<Cliente> clientes;
    
    public ModeloTabelaCliente(ArrayList<Cliente> Clientes ){
        this.clientes = new ArrayList<>();
    
     
    }
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public  int getRowCount(){
        return  clientes.size();
    }

    @Override
    public String getColumnName (int columnIndex){
        return colunas[columnIndex];        
    }  
    @Override
    public boolean isCellEditable (int rowIndex,int columnIndex){
        return false;
    }
    @Override
    public Object getValueAt(int row,int col){ 
        Cliente cliente = clientes.get(row);

        switch(col){
            
            case COLUNA_NOME:  
                return cliente.getNome();
            
            case COLUNA_EMAIL:   
                return cliente.getEmail();
            
            case COLUNA_TELEFONE:
                return cliente.getTelefone();
             
            case COLUNA_RUA:
                return cliente.getRua();
                
            case COLUNA_BAIRRO:
                return cliente.getBairro();
                
            case COLUNA_CIDADE:
                return cliente.getCidade();
            
            case COLUNA_ESTADO:
                return cliente.getEstado();
                
            case COLUNA_NUMERO:
                return cliente.getNumero();
                
            case COLUNA_COMPLEMENTO:
                return cliente.getComplemento();

        }
       
        return  "";
        
        
        

          
    }
   
   @Override
   public void setValueAt (Object aValue , int row , int column){
        Cliente cliente = clientes.get(row);
        switch(column){
           case COLUNA_NOME:  
                cliente.setNome(aValue.toString());
            
            case COLUNA_EMAIL:   
                cliente.setEmail(aValue.toString());
            
            case COLUNA_TELEFONE:
                cliente.setTelefone(aValue.toString());
             
            case COLUNA_RUA:
                cliente.setRua(aValue.toString());
                
            case COLUNA_BAIRRO:
                cliente.setBairro(aValue.toString());
                
            case COLUNA_CIDADE:
                cliente.setCidade(aValue.toString());
            
            case COLUNA_ESTADO:
                cliente.setEstado(aValue.toString());
                
            case COLUNA_NUMERO:
                cliente.setNumero(aValue.toString());
                
            case COLUNA_COMPLEMENTO:
                cliente.setComplemento(aValue.toString());
        }
    }
   
   
   public Cliente obterCliente(int indice){
       return clientes.get(indice);
   
   
   }
   public void incluirCliente(Cliente cliente){
       clientes.add(cliente);
       int ultimo = getRowCount() -1;  
       fireTableRowsInserted(ultimo, ultimo);
   }
   public void atualizarCliente(int indice, Cliente cliente){
   
        clientes.set(indice,cliente);   
        fireTableRowsUpdated(indice , indice);
   
   }
   public void excluirCliente( int indice){
        clientes.remove(indice);
        fireTableRowsDeleted(indice , indice);
    }
   
    
    

}



  




    

 
    
    
    

