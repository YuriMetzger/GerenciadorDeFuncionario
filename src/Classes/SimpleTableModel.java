package Classes;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class SimpleTableModel 
        extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public String [] getColunas(){
        return colunas;
    }
    
    public ArrayList getLinhas(){
        return linhas;
    }
    
    private void setColunas(String [] strings){
        colunas = strings;
    }
    
    private void setLinhas (ArrayList list){
        linhas = list;
    }
    
    public int getRowCount(){
      return getLinhas().size();
    }
    
    public int getColumnCount(){
        return getColunas().length;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public Object getValueAt(int rowindex, 
            int columnindex){
        String[] linha = 
         (String [])getLinhas().get(rowindex);
        return linha[columnindex];
    }
    
    public SimpleTableModel(ArrayList dados,
            String[] colunas){
        this.setColunas(colunas);
        this.setLinhas(dados);
    }
    
    public String getValues(java.awt.event.MouseEvent e){
        
        return "";
    }
    
}
