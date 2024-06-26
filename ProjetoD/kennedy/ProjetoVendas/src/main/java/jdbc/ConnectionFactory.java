package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jabes
 */
public class ConnectionFactory {
    
        public Connection getConnection(){
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/BdVendas", "root", "");
                return connection;
            }catch(SQLException ex){
                System.err.print("Cause");
            }
            return null;
        }
}
