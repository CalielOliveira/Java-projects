package model.DAO;

import connection.ConnectionFactory;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Arquivo;

/**
 *
 * @author olive
 */
public class OrganizadorDAO {
    
    public static void salvarDados(List<Arquivo> a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            for (Arquivo a1 : a) {
            stmt = con.prepareStatement("insert into imagens (dados, nome) VALUES (?, ?)");
            stmt.setBlob(1, a1.toBlob());
            stmt.setString(2, a1.getName());
            stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }catch (HeadlessException | SQLException ex){
            Logger.getLogger(OrganizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }

        ConnectionFactory.closeConnection(con, stmt);       
    }
    
    
    public static List<Arquivo> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Arquivo> arquivos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("select * from imagens");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Arquivo oc = new Arquivo(rs.getBytes("dados"),rs.getString("nome"));
                
                arquivos.add(oc);
                               
            }

        }catch(SQLException ex){
            Logger.getLogger(OrganizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar tabela");
        } catch (IOException ex) {
            Logger.getLogger(OrganizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return arquivos;             
    }    
    public static void excluirDados(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("delete from imagens");
                       
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");           
        }catch(SQLException ex){
            Logger.getLogger(OrganizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Ocorrencia");
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }   
}

