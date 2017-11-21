/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thalia
 */
public class Cargo {
    private int idCargo;
    private String cargo;
    private int departamento;
    private String departamentoString;
    private final Conexao conexao = new Conexao();

    public String getDepartamentoString() {
        return departamentoString;
    }

    public void setDepartamentoString(String departamentoString) {
        this.departamentoString = departamentoString;
    }

    public Cargo(int idCargo, String cargo, String departamentoString) {
        this.cargo = cargo;
        this.departamentoString = departamentoString;
        this.idCargo = idCargo;
    }
    
    public Cargo(){
        
    }
    
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
    
    public void cadastrarCargo() throws SQLException
    {   
        if( verificarJaExistente( this.getCargo() ) ){
            try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "insert into cargo (idCargo, cargo, id_departamento)"
                            + " values (0,?,?)")) {
                pst.setString( 1, this.getCargo() );
                pst.setInt( 2, this.getDepartamento() );
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cargo cadastrado!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cargo já existe!");
        }
        
        conexao.close();   
    }
    
    public int getCodigoCargo(Cargo cargo) throws SQLException{
        ResultSet rs;
        int cargoid = 0;
        try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "select idCargo from cargo " +
                 "where (cargo = ?)")) {
            pst.setString(1, cargo.getCargo());
            
            rs = pst.executeQuery();
            rs.first();
            cargoid = rs.getInt("idCargo");
        }
        rs.close();
        conexao.close();
        
        return cargoid;
    }
    
    public void EditarCargo() throws SQLException {
         try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "UPDATE cargo SET cargo = ? , id_departamento = ?  WHERE idCargo = ?") ) {
            pst.setString(1, this.getCargo() );
            pst.setInt(2, this.getDepartamento() );
            pst.setInt(3, this.getIdCargo() );
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Departamento Editado!");
        }
        conexao.close();
    }
        public void deletarCargo() throws SQLException {
            try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "DELETE FROM cargo WHERE idCargo = ?")) {
                pst.setInt(1, this.getIdCargo());
                 pst.executeUpdate();
            }
            conexao.close();
        }
    
    
    
    public ArrayList<Cargo> listarCargos() throws SQLException
    {
        ResultSet rs;
        ArrayList<Cargo> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery(
                    "select cargo.idCargo, cargo.cargo,departamento.departamento from cargo, departamento"
                    + " where cargo.id_departamento = departamento.idDepartamento");
            lista = new ArrayList<>();
            
            while(rs.next())
            {
                lista.add( new Cargo( rs.getInt("idCargo"), rs.getString("cargo"), rs.getString("departamento") ) );
            }
        }
        conexao.close();
        
        return lista;
    }
    
    public boolean verificarJaExistente( String nome ) throws SQLException{
        
        ResultSet rs;
        int soma = 0;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery("select count(*) as soma from cargo where cargo = '"+nome+"'"); 
            rs.first();
            soma = rs.getInt("soma");
        }
        conexao.close();
        return ( soma != 1 );
        
    }
    
}
