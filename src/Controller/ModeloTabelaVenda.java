/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ItemVenda;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mp
 */
public class ModeloTabelaVenda extends AbstractTableModel{
    private static final int  COLUNA_CODIGO_PRODUTO=0;
    private static final int  COLUNA_NOME_PRODUTO=1;
    private static final int  COLUNA_PRECO = 2;
    private static final int  COLUNA_QUANTIDADE=3;
    private static final int  CODIGO_TOTAL_DO_ITEM=4;
    
    private String[] colunas = new String[]{"codigoProduto","NomeProduto","Preço","Quantidade","totalItem"};
    private ArrayList<ItemVenda> itemVendidos;
   
    public ModeloTabelaVenda( ArrayList <ItemVenda> itemVendidos){
        this.itemVendidos = new ArrayList<ItemVenda>(itemVendidos);
       
    }
    @Override
    public  int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return itemVendidos.size();
    }
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    @Override
    public boolean isCellEditable(int rowIndex , int columnIndex){
        return false;
    }
    @Override
    public Object getValueAt (int row,int col){
        ItemVenda itemVendido = itemVendidos.get(row);
        switch(col){
            case COLUNA_CODIGO_PRODUTO:
                return itemVendido.getCodigoProduto();
            case COLUNA_NOME_PRODUTO:
                return itemVendido.getNomeProduto();
            case COLUNA_PRECO:
                return itemVendido.getPreco();
            case COLUNA_QUANTIDADE:
                return itemVendido.getQuantidadeVendida();
            case CODIGO_TOTAL_DO_ITEM:
                return itemVendido.getTotalItem();
        }
        return "";
    
    }
    
       
  
    @Override
    public void setValueAt(Object aValue,int row,int column){
        ItemVenda itemVendido = itemVendidos.get(row);
        switch(column){
            case COLUNA_CODIGO_PRODUTO:
                itemVendido.setCodigoProduto(aValue.toString());
            case COLUNA_NOME_PRODUTO:
                itemVendido.setNomeProduto(aValue.toString());
            case COLUNA_PRECO:
                itemVendido.setPreco(aValue.toString());  
            case COLUNA_QUANTIDADE:
                itemVendido.setQuantidadeVendida(aValue.toString());
            case CODIGO_TOTAL_DO_ITEM:
                itemVendido.setTotalItem(aValue.toString());
        }
      
       
    }
    public ItemVenda obterItemVenda(int indice){
       return itemVendidos.get(indice);
     
    } 
    public void incluirItemVenda(ItemVenda itemVendido){
        itemVendidos.add(itemVendido);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);  
    }
    public void atualizarItemVenda(int indice, ItemVenda itemVendido){
   
        itemVendidos.set(indice,itemVendido);   
        fireTableRowsUpdated(indice , indice);
   
   }
   public void excluirItemVenda( int indice){
        itemVendidos.remove(indice);
        fireTableRowsDeleted(indice , indice);
    }
}
