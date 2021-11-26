package model.dao;

import connections.ConnectionFactory;
//import java.awt.List;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Visita;

/**
 *
 * @author Nelson Batista
 */
public class VisitaDAO {
    
    
    public static void create(Visita v){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	try {
		stmt = con.prepareStatement("INSERT INTO visita (Nome, CPF, Endereco, CEP, Celular, Codigo_Gerado, Andar, Sala)VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		stmt.setString(1,v.getNome());
                stmt.setString(2,v.getCpf());
                stmt.setString(3,v.getEndereco());
                stmt.setString(4,v.getCep());
                stmt.setString(5,v.getCelular());
                stmt.setString(6,v.getCodigoGerado());
                stmt.setString(7,v.getAndar());
                stmt.setString(8,v.getSala());

		stmt.executeUpdate();

		JOptionPane.showMessageDialog(null, "Salvo com sucesso.");

	} catch (SQLException ex) {
		Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
		JOptionPane.showMessageDialog(null, "Erro ao salvar"+ex);
        }
        finally{
        ConnectionFactory.closeConnection(con, stmt);
        }
    
}
    
    /**
     *
     * @return
     */
    public static List<Visita> read() {
       	Connection con = ConnectionFactory.getConnection();//abre a conexao
	PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Visita> visitas = new ArrayList<>();
        
    try{  
            stmt = con.prepareStatement("SELECT * FROM visita");
            rs = stmt.executeQuery();

               while (rs.next()){
               Visita visita = new Visita();
               visita.setCodigo(rs.getInt("Codigo"));
               visita.setNome(rs.getString("Nome"));
               visita.setCpf(rs.getString("CPF"));
               visita.setEndereco(rs.getString("Endereco"));
               visita.setCep(rs.getString("CEP"));
               visita.setCelular(rs.getString("Celular"));
               visita.setCodigoGerado(rs.getString("Codigo_Gerado"));
               visita.setAndar(rs.getString("Andar"));
               visita.setSala(rs.getString("Sala"));
               visitas.add(visita);
               
               }
                
      } catch (SQLException ex){
            Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
      }finally{}
      return visitas;
    }
    
    
    public static void update (Visita v){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;

	try {
		stmt = con.prepareStatement("UPDATE visita SET Nome = ?, CPF = ?, Endereco = ?, CEP = ?, Celular = ?, Codigo_Gerado = ?, Andar = ?, Sala = ? "
                        + "WHERE Codigo = ?");
		stmt.setString(1,v.getNome());
		stmt.setString(2,v.getCpf());
		stmt.setString(3,v.getEndereco());
		stmt.setString(4,v.getCep());
		stmt.setString(5,v.getCelular());
		stmt.setString(6,v.getCodigoGerado());
                stmt.setString(7,v.getAndar());
                stmt.setString(8,v.getSala());
               	stmt.setInt(9,v.getCodigo());

		stmt.executeUpdate();

		JOptionPane.showMessageDialog(null, "Atualizado com sucesso.");

	} catch (SQLException ex) {
		Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
		JOptionPane.showMessageDialog(null, "Erro ao atualizar "+ex);

}
finally{
ConnectionFactory.closeConnection(con, stmt);
}
}
    
    public static void delete (Visita v){
	Connection con = ConnectionFactory.getConnection();
	PreparedStatement stmt = null;
	
	try {
		stmt = con.prepareStatement("DELETE FROM visita WHERE Codigo = ?");                
	        stmt.setInt(1,v.getCodigo());

		stmt.executeUpdate();

		JOptionPane.showMessageDialog(null, "Excluido com sucesso.");


	} catch (SQLException ex) {
		Logger.getLogger(VisitaDAO.class.getName()).log(Level.SEVERE, null, ex);
		JOptionPane.showMessageDialog(null, "Erro ao exlcuir "+ex);

}
finally{
    ConnectionFactory.closeConnection(con, stmt);
}

    
} 

    
 
}

