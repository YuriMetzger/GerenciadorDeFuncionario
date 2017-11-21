package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
public Connection connection = null;

public Connection getConexao(){ 
  final String DRIVER =  "com.mysql.jdbc.Driver";
  final String URL = "jdbc:mysql://localhost:3306/Trabalho";
  
  try {
      Class.forName(DRIVER);
      connection = 
      DriverManager.getConnection(URL, "root", "");
      return connection;
  }catch(ClassNotFoundException e){
      JOptionPane.showMessageDialog(null, 
      "Driver não encontrado: " + 
              e.toString());
  }catch (SQLException e) {
    JOptionPane.showMessageDialog(null, 
      "Problemas na fonte de dados: " + 
              e.toString());
      
  }
    return null;
 }

public void close(){
    try {
        connection.close();
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, 
    "Problemas ao fechar conexão" + 
    e.toString());        
    }
}
}