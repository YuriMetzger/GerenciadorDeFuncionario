
package Classes;

import Classes.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Beneficios {
    private String beneficio;
    private int idBeneficio;

    public Beneficios(int idBeneficio, String beneficio) {
        this.beneficio = beneficio;
        this.idBeneficio = idBeneficio;
    }
    
    public Beneficios() {
        this.beneficio = "";
        this.idBeneficio = 0;
    }
    
    
    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }
    private final Conexao conexao = new Conexao();

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }
    
    public void cadastrarBeneficio() throws SQLException
    {
        try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "insert into beneficio (idBeneficio, beneficio)"
                        + " values (0,?)")) {
            pst.setString(1, this.getBeneficio());
            pst.executeUpdate();
        }
        conexao.close();
    }
    
    public void deletarBeneficio( int idBeneficio ) throws SQLException
    {
        try (PreparedStatement pst = 
                conexao.getConexao().prepareStatement(
                "DELETE FROM beneficio WHERE idBeneficio = ?") ) {
            pst.setInt(1, idBeneficio );
            pst.executeUpdate();
        }
        conexao.close();
    }
    
    public ArrayList<Beneficios> listarBeneficio() throws SQLException
    {
        ResultSet rs;
        ArrayList<Beneficios> lista;
        
        try (Statement st = conexao.getConexao().createStatement()) {
            rs = st.executeQuery(
                    "select * from obra ");
            lista = new ArrayList<Beneficios>();
            
            while(rs.next())
            {
                lista.add( new Beneficios( rs.getInt("idBeneficio"), rs.getString("beneficio") ) );
            }
        }
        conexao.close();
        
        return lista;
    } 
    
}
