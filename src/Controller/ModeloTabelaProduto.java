/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Produto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mp
 */
public class ModeloTabelaProduto extends AbstractTableModel{
    private static final int  COLUNA_CODIGO=0;
    private static final int  COLUNA_NOME=1;
    private static final int  COLUNA_PRECO=2;
    private static final int  CODIGO_QUANTIDADE=3;
    
    private String[] colunas = new String[]{"codigo","nome","preco","quantidade"};
    private ArrayList<Produto> produtos;

    
    public ModeloTabelaProduto (ArrayList<Produto> produtos){
        this.produtos = new ArrayList<>();
   
    }
    @Override
    public  int getColumnCount(){
        return colunas.length;
    }
    @Override
    public int getRowCount(){
        return produtos.size();
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
        Produto produto = produtos.get(row);
        switch(col){
            case COLUNA_CODIGO:
                return produto.getCodigoProduto();
            case COLUNA_NOME:
                return produto.getNome();
            case COLUNA_PRECO:
                return produto.getPreco();
            case CODIGO_QUANTIDADE:
                return produto.getQuantidadeEstoque();
        }
        return "";
    
    }
    @Override
    public void setValueAt(Object aValue,int row,int column){
        Produto produto = produtos.get(row);
        switch(column){
            case COLUNA_CODIGO:
                produto.setCodigoProduto(aValue.toString());
            case COLUNA_NOME:
                produto.setNome(aValue.toString());
            case COLUNA_PRECO:
                produto.setPreco(aValue.toString());
            case CODIGO_QUANTIDADE:
                produto.setQuantidadeEstoque(aValue.toString());
        }
      
       
    }
    public Produto obterProduto(int indice){
       return produtos.get(indice);
     
    } 
    public void incluirProduto(Produto produto){
        produtos.add(produto);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
        
    }
    public void atualizarProduto(int indice, Produto produto){
   
        produtos.set(indice,produto);   
        fireTableRowsUpdated(indice , indice);
   
   }
   public void excluirProduto( int indice){
        produtos.remove(indice);
        fireTableRowsDeleted(indice , indice);
    }

    
}
