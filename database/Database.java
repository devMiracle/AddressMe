package address.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    
    private static Connection connect;
    
    public Database(){}
    
    public static Connection getMyConnection(){
        try 
        {
//            File file = new File("ConnectionString.properties");
//            String pathFile = file.getPath();
//            Properties fileName = new Properties();
//            fileName.load(new FileInputStream(pathFile));
//            
            connect = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=ResidentialAddress","sa","sa");
        }
        catch (SQLException sqle) 
        {
            System.out.println(sqle.getMessage());
        }
        return connect;
    }
    
}
