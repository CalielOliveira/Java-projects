package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class ConnectionFactory {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:./database/apsDB;IFEXISTS=TRUE";
    private static final String USER = "sa";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro ao conectar ao banco de dados: "+ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        try {
            if(rs != null) rs.close();
            con.close();
        }catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        try {
            con.close();
        }catch (SQLException ex){
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

