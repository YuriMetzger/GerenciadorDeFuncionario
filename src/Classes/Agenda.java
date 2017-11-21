/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import trabalho.CadFuncionario;

/**
 *
 * @author João e Thalia
 */


public class Agenda {
    private String titulo;
    private String idAgenda;
    private String nomeFuncionario;
    private int idFuncionario;
    private String prioridade;
    private String data;
    private String hora;
    private String ativo;

    private final Conexao conexao = new Conexao();
    private CadFuncionario funcionario = new CadFuncionario();

    
    public Agenda( String titulo, String nomeFuncionario, String prioridade, String data, String hora, String Agenda, String ativo) {
        this.titulo = titulo;
        this.nomeFuncionario = nomeFuncionario;
        this.prioridade = prioridade;
        this.data = data;
        this.hora = hora;
        this.idAgenda = Agenda;
        this.ativo = ativo;
    }

    public Agenda(){
        
    }
    
    
    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
    
    public String getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(String idAgenda) {
        this.idAgenda = idAgenda;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public void cadastrarAgenda() throws SQLException
    {  
        CadFuncionario funcionario = new CadFuncionario();

        if( verificarJaExistente( this.titulo, this.data, this.hora )){
            conexao.close();
            try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "insert into agenda(idAgenda, titulo, data, prioridade, hora, idFuncionario, ativo)"
                            + " values (0,?,?,?,?,?,?)")) {
                pst.setString( 1, this.getTitulo() );
                pst.setString( 2, this.getData() );
                pst.setString( 3, this.getPrioridade() );
                pst.setString( 4, this.getHora() );
                pst.setInt( 5, this.getIdFuncionario() );
                pst.setString(6, "1");
                
                pst.executeUpdate();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Agenda já cadastrada!");
        }
        conexao.close();   
    }
    public void atualizaAgenda(String ID) throws SQLException{
       CadFuncionario funcionario = new CadFuncionario();
        try(PreparedStatement pst = 
            conexao.getConexao().prepareStatement("UPDATE agenda SET titulo = ?, prioridade = ?, data = ?, hora = ?, idFuncionario = ?, ativo =? where idAgenda ="+ID)){
            pst.setString(1, this.getTitulo());
            pst.setString( 3, this.getPrioridade());
            pst.setString( 2, this.getData() );
            pst.setString( 4, this.getHora() );
            pst.setInt( 5, this.getIdFuncionario() );
            pst.setString(6, "1");
            
            pst.executeUpdate();
            conexao.close();
            
        };
    }

    public void excluiItemAgenda(String ID) throws SQLException{
        try(PreparedStatement pst = conexao.getConexao().prepareStatement("UPDATE agenda SET ativo = 0 WHERE idAgenda ="+ID)){
            pst.executeUpdate();
            conexao.close();
        }
    }
    
    public ArrayList<Agenda> listarAgenda() throws SQLException
    {
        ResultSet rs;
        ArrayList<Agenda> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery(
                    "select a.idAgenda, a.data, a.hora, a.titulo, a.prioridade, a.ativo, f.idFuncionario from agenda a, funcionario f"
                    + " where f.idFuncionario = a.idFuncionario and ativo <> 0");
            lista = new ArrayList<>();
            
            while(rs.next())
            {
                lista.add( new Agenda(  rs.getString("titulo"), rs.getString("idFuncionario"), rs.getString("prioridade"), 
                rs.getString("data"), rs.getString("hora"), rs.getString("idAgenda"), rs.getString("ativo")));
            }
        }
        conexao.close();
        
        return lista;
    }
    public boolean verificarJaExistente( String titulo, String data, String hora) throws SQLException{
        
        ResultSet rs;
        int soma = 0;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery("select count(*) as soma from agenda where titulo = '"+titulo+"'"
                    + " and data = "+data+" and hora = "+hora+""); 
            rs.first();
            soma = rs.getInt("soma");
        }
        conexao.close();
        return ( soma != 1 );
        }        
    }
    

