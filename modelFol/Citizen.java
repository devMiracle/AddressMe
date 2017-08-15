package address.model;

import address.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Citizen {
    
    private String firstName;
    private String middleName;
    private String lastName;
    private int roomNo;
    private int buildingId;
    private String streetId;

    public Citizen(){}
    
    public boolean Update(String newFirstName,String newMiddleName, String newLastName, int newRoomNo, int newBuildingId, String newStreetId){
        boolean update = false;
        try(
            Connection connect = Database.getMyConnection();
            PreparedStatement prs = connect.prepareStatement("insert into citizen values(?,?,?,?,?,?)");   
            )
        {
          prs.setString(1, newFirstName);
          prs.setString(2, newMiddleName);
          prs.setString(3, newLastName);
          prs.setInt(4, newRoomNo);
          prs.setInt(5, newBuildingId);
          prs.setString(6, newStreetId);
          
          int rowAffected = prs.executeUpdate();
            if(rowAffected>0)
                {
                    update = true;
                } 
        }
        catch(SQLException sqle){
            sqle.getMessage();
        }
        return update;
    }
    public boolean Update(String newFirstName,String newLastName, int newRoomNo, int newBuildingId, String newStreetId){
        boolean update = false;
        try(
            Connection connect = Database.getMyConnection();
            PreparedStatement prs = connect.prepareStatement("insert into citizen (vCitizenLastname,vCitizenFirstName,iCitizenRoomNo,iBuildingId,vStreetId) values(?,?,?,?,?)");   
            )
        {
          prs.setString(1, newFirstName);
          prs.setString(2, newLastName);
          prs.setInt(3, newRoomNo);
          prs.setInt(4, newBuildingId);
          prs.setString(5, newStreetId);
          
          int rowAffected = prs.executeUpdate();
            if(rowAffected>0)
                {
                    update = true;
                } 
        }
        catch(SQLException sqle){
            sqle.getMessage();
        }
        return update;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(String roomNo) {
        this.setRoomNo(roomNo);
    }

    /**
     * @param buildingNo the buildingNo to set
     */
    public void setBuildingNo(String buildingNo) {
        this.setBuildingNo(buildingNo);
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
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
    
    /**
     * @return the roomNo
     */
    public int getRoomNo() {
        return roomNo;
    }

    /**
     * @param buildingNo the buildingNo to set
     */
    
    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }
     /**
     * @return the buildingNo
     */
    public int getBuildingId() {
        return buildingId;
    }
    
}
