
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Funcionario {
    private int codigo;
    private String cpf;
    private String rg;
    private String nome;
    private String situacao;
    private String dataNasc;
    private String dataAdmissao;
    private String descricao;
    private String beneficios;
    private int cargo;
    private String email;
    private String naturalidade;
    private boolean ativo;
    private boolean  inativo;
    private boolean  vale_trans;
    private boolean vale_refe;
    private boolean aux_edu;
    private boolean plano_saude;
    private final Conexao conexao = new Conexao();

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isInativo() {
        return inativo;
    }

    public void setInativo(boolean inativo) {
        this.inativo = inativo;
    }

    public boolean isVale_trans() {
        return vale_trans;
    }

    public void setVale_trans(boolean vale_trans) {
        this.vale_trans = vale_trans;
    }

    public boolean isVale_refe() {
        return vale_refe;
    }

    public void setVale_refe(boolean vale_refe) {
        this.vale_refe = vale_refe;
    }

    public boolean isAux_edu() {
        return aux_edu;
    }

    public void setAux_edu(boolean aux_edu) {
        this.aux_edu = aux_edu;
    }

    public boolean isPlano_saude() {
        return plano_saude;
    }

    public void setPlano_saude(boolean plano_saude) {
        this.plano_saude = plano_saude;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Funcionario(int codigo, int aInt1, String cpf, String rg, String nome, String situacao, String dataNasc, String dataAdmissao, String descricao, int cargo, String email, String naturalidade) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.situacao = situacao;
        this.dataNasc = dataNasc;
        this.dataAdmissao = dataAdmissao;
        this.descricao = descricao;
        this.cargo = cargo;
        this.email = email;
        this.naturalidade = naturalidade;
    }

    public Funcionario(){
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    public ArrayList<Integer> Beneficios(){
        ArrayList<Integer> beneficios = new ArrayList<Integer>();
        
        if( this.vale_trans ){
            beneficios.add(1);
        }else if( this.vale_refe ){
            beneficios.add(2);
        }else if( this.plano_saude ){
            beneficios.add(3);
        }
        
        return beneficios;
    }
    
    public ArrayList<Funcionario> listarFuncionario() throws SQLException
    {
        ResultSet rs;
        ArrayList<Funcionario> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery(
                    "select * from funcionario");
            lista = new ArrayList<>();
            
            while(rs.next())
            {
                lista.add( new Funcionario(rs.getInt("idFuncionario"), rs.getInt("codigo"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome_funcionario"), rs.getString("situacao"), rs.getString("dataNasc"), rs.getString("dataAdmissao"), rs.getString("descricao"), rs.getInt("cargo"), rs.getString("email"), rs.getString("naturalidade")));             
            }
        }
        conexao.close();
        
        return lista;
    }  
    
     public void cadastrarFuncionario() throws SQLException
    {
            try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "insert into funcionario"
                            + " values (0,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
                pst.setString(1, this.getNome());
                pst.setString(2, this.getCpf());
                pst.setString(3, this.getNome());
                pst.setString(4, this.getRg());
                pst.setString(5, this.getNaturalidade());
                pst.setString(6, this.getBeneficios());
                pst.setString(7, this.getDataNasc());
                pst.setString(8, this.getDataAdmissao());
                pst.setString(9, this.getDescricao());
                pst.setInt(10, this.getCodigo());
                pst.setString(11, this.getSituacao());
                pst.setInt(12, this.getCargo());
                pst.setString(13, this.getEmail());
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Funcionario Cadastrado!");
            }
            conexao.close();
    
    }
}
