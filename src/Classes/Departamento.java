package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Classes.Conexao;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;

public class Departamento {
    private int idDepartamento;
    private String departamento;
    private final Conexao conexao = new Conexao();

    public Departamento(int idDepartamento, String departamento) {
        this.idDepartamento = idDepartamento;
        this.departamento = departamento;
    }
    
    public Departamento() {
        this.idDepartamento = 0;
        this.departamento = "";
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void cadastrarDepartamento() throws SQLException
    {
        if( !verifica_existe( this.getDepartamento() ) ){
            
            try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "insert into departamento (idDepartamento, departamento)"
                            + " values (0,?)")) {
                pst.setString(1, this.getDepartamento());
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Departamento Cadastrado!");
            }
            conexao.close();
        
        }else{
            JOptionPane.showMessageDialog(null, "Esse departamento já foi cadastrado!");
        }
    }
    
    public void deletarDepartamento( String departamento ) throws SQLException
    {
        if( verifica_existe( departamento ) ){
            try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "DELETE FROM departamento WHERE departamento = ?") ) {
                pst.setString(1, departamento );
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Departamento Excluído!");
            }catch(MySQLIntegrityConstraintViolationException ex){
                JOptionPane.showMessageDialog(null, "Departamento em uso!");
            }
            conexao.close();
        }else{
            JOptionPane.showMessageDialog(null, "Não existe o departamento informado!");
        }
    }
    
    public void editarDepartamento() throws SQLException
    {
        try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "UPDATE departamento SET departamento = ? WHERE idDepartamento = ?") ) {
            pst.setString(1, this.getDepartamento());
            pst.setInt(2, this.getIdDepartamento() );
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Departamento Editado!");
        }
        conexao.close();

    }
    
    public ArrayList<Departamento> listarDepartamentos() throws SQLException
    {
        ResultSet rs;
        ArrayList<Departamento> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery("select * from departamento");
            lista = new ArrayList<Departamento>();
            
            while(rs.next())
            {
                lista.add( new Departamento( rs.getInt("idDepartamento"), rs.getString("departamento") ) );
            }
        }
        conexao.close();
        
        return lista;
    } 
    
    public void preencheDepartamento(  ){
        
    }
    
    public boolean verifica_existe( String departamento ) throws SQLException
    {
        ResultSet rs;
        int qtd = 0;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery("select count(*) as qtd from departamento where departamento = '"+departamento+"'");
            rs.first();
            qtd = rs.getInt("qtd");
        }
        conexao.close();
        
        return qtd > 0;
    }
    
}
