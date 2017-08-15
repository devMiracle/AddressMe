package address.model;

import address.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckStreet {
    private String streetId;
    private String streetName;
    
    public CheckStreet(){}
    
    public void checkStreet(String newStreetName){
        
        try(
             Connection connect = Database.getMyConnection();
             PreparedStatement prs = connect.prepareStatement("select vstreetId,vstreetname from streets where vstreetname = ?");
            )
        {
            prs.setString(1, newStreetName);
            ResultSet result = prs.executeQuery();
            result.next();
            
            setStreetName(result.getString("vstreetname"));
            setStreetId(result.getString("vstreetid"));
            
        }
        catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        
    }
    
    /**
     * @return the streetId
     */
    public String getStreetId() {
        return streetId;
    }

    /**
     * @param streetId the streetId to set
     */
    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    
}
