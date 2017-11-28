
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
    private int ativo;
    private int  inativo;
    private int  vale_trans;
    private int vale_refe;
    private int aux_edu;
    private int plano_saude;
    private int outros;

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }
    private final Conexao conexao = new Conexao();
   

    public int isAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int isInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public int isVale_trans() {
        return vale_trans;
    }

    public void setVale_trans(int vale_trans) {
        this.vale_trans = vale_trans;
    }

    public int isVale_refe() {
        return vale_refe;
    }

    public void setVale_refe(int vale_refe) {
        this.vale_refe = vale_refe;
    }

    public int isAux_edu() {
        return aux_edu;
    }

    public void setAux_edu(int aux_edu) {
        this.aux_edu = aux_edu;
    }

    public int isPlano_saude() {
        return plano_saude;
    }

    public void setPlano_saude(int plano_saude) {
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

    public Funcionario(int codigo, String cpf, String rg, String nome, String situacao, String dataNasc, String dataAdmissao, String descricao, int cargo, String email, String naturalidade, int ativo, int inativo, int vale_trans, int vale_refe, int aux_edu, int plano_saude, int outros) {
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
        this.ativo = ativo;
        this.inativo = inativo;
        this.vale_trans = vale_trans;
        this.vale_refe = vale_refe;
        this.aux_edu = aux_edu;
        this.plano_saude = plano_saude;
        this.outros = outros;
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
        
        if( this.vale_trans == 1){
            beneficios.add(1);
        }
        
        if( this.vale_refe == 1){
            beneficios.add(2);
        }
        
        if( this.plano_saude == 1 ){
            beneficios.add(3);
        }
        
        if( this.aux_edu == 1 ){
            beneficios.add(4);
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
                lista.add( new Funcionario(rs.getInt("idFuncionario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome_funcionario"), rs.getString("situacao"), rs.getString("dataNasc"), rs.getString("dataAdmissao"), rs.getString("descricao"), rs.getInt("cargo"), rs.getString("email"), rs.getString("naturalidade"), rs.getInt("ativo"), rs.getInt("inativo"), rs.getInt("vale_trans"), rs.getInt("vale_ref"), rs.getInt("aux_edu"), rs.getInt("plano_saude"), rs.getInt("outros")));             
            }
        }
        conexao.close();
        
        return lista;
    }
        public ArrayList<Funcionario> PesquisaFuncionario(String query) throws SQLException
    {
        ResultSet rs;
        ArrayList<Funcionario> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery(query);
            lista = new ArrayList<>();
            
            while(rs.next())
            {
                lista.add( new Funcionario(rs.getInt("idFuncionario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome_funcionario"), rs.getString("situacao"), rs.getString("dataNasc"), rs.getString("dataAdmissao"), rs.getString("descricao"), rs.getInt("idCargo"), rs.getString("email"), rs.getString("naturalidade"), rs.getInt("ativo"), rs.getInt("inativo"), rs.getInt("vale_trans"), rs.getInt("vale_ref"), rs.getInt("aux_edu"), rs.getInt("plano_saude"), rs.getInt("outros")));             
            }
        }
        conexao.close();
        
        return lista;
    }  
    
    public void cadastrarFuncionario() throws SQLException
    {         
        ResultSet rs;
        int codigoFuncionario = 0;
        ArrayList<Integer> lista = new  ArrayList<Integer>();
        
        try (PreparedStatement pst = 
                    conexao.getConexao().prepareStatement(
                    "insert into funcionario( nome_funcionario, cpf, rg, naturalidade, dataNasc, "
                            + "dataAdmissao, descricao, ativo, codigo, situacao, cargo, email, vale_trans, vale_ref,"
                            + "aux_edu, outros, plano_saude, inativo )"
                            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ")) {
                
                /* Cadastro de Funcionários Inicio */
                pst.setString(1, this.getNome());
                pst.setString(2, this.getCpf());
                pst.setString(3, this.getRg());
                pst.setString(4, this.getNaturalidade());
                pst.setString(5, this.getDataNasc());
                pst.setString(6, this.getDataAdmissao());
                pst.setString(7, this.getDescricao());
                pst.setInt(8, this.isAtivo());
                pst.setInt(9, this.getCodigo());
                pst.setString(10, this.getSituacao());
                pst.setInt(11, this.getCargo());
                pst.setString(12, this.getEmail());
                pst.setInt(13, this.isVale_trans());
                pst.setInt(14, this.isVale_refe());
                pst.setInt(15, this.isAux_edu());
                pst.setInt(16, this.getOutros());
                pst.setInt(17, this.isPlano_saude());
                pst.setInt(18, this.isInativo());
                pst.executeUpdate();
                /* Cadastro de Funcionários Fim */
    
                JOptionPane.showMessageDialog(null, "Funcionário Cadastrado!");
            }
    }
    
    public void deletarFuncionario( int codigo ) throws SQLException {
        try (PreparedStatement pst = 
            conexao.getConexao().prepareStatement(
            "DELETE FROM funcionario WHERE idFuncionario = ?")) {
            pst.setInt(1, codigo);
             pst.executeUpdate();
             
             JOptionPane.showMessageDialog(null, " Funcionario Deletado!");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        conexao.close();
    }
    
    public void editarFuncionario() throws SQLException{
        try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "UPDATE funcionario SET nome_funcionario = ?, cpf = ?, rg = ?, naturalidade = ?, dataNasc = ?, "
                            + "dataAdmissao = ?, descricao = ?, ativo = ?,situacao = ?, cargo = ?, email = ?, vale_trans = ?, vale_ref = ?,"
                            + "aux_edu = ?, outros = ?, plano_saude = ?, inativo = ?  WHERE idFuncionario = ?") ) {
            pst.setString(1, this.getNome());
                pst.setString(2, this.getCpf());
                pst.setString(3, this.getRg());
                pst.setString(4, this.getNaturalidade());
                pst.setString(5, this.getDataNasc());
                pst.setString(6, this.getDataAdmissao());
                pst.setString(7, this.getDescricao());
                pst.setInt(8, this.isAtivo());
                pst.setString(9, this.getSituacao());
                pst.setInt(10, this.getCargo());
                pst.setString(11, this.getEmail());
                pst.setInt(12, this.isVale_trans());
                pst.setInt(13, this.isVale_refe());
                pst.setInt(14, this.isAux_edu());
                pst.setInt(15, this.getOutros());
                pst.setInt(16, this.isPlano_saude());
                pst.setInt(17, this.isInativo());
                pst.setInt(18, this.getCodigo());
            
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Departamento Editado!");
        }
        conexao.close();
    }
}
