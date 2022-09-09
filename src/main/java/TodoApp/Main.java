package TodoApp;

import java.sql.Connection;
import util.ConnectionFactory;

/**
 *
 * @author Ana�sa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection c = ConnectionFactory.getConnection();
        
        ConnectionFactory.closeConnection(c);
        
    }
    
}
