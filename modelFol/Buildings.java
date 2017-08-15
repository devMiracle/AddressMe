package address.model;

import address.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Buildings {
    
    private int buildingId;
    private int buildingNo;
    private String buildingName;
    private String buildingNameOfOwner;
    private String buildingType;
    private String streetName;
    private String streetId;
    private String districtName;
    private String lgaName;
    private String stateName;
    private String countryName;
    
    public Buildings(){}
    
    public boolean registerBuilding(int newBuildingNo, String newBuildingName, String newBuildingNameOfOwner, String newBuildingType, String newStreetId){
        boolean isRegister=false;
        try(
                Connection connect = Database.getMyConnection();
                PreparedStatement prs = connect.prepareStatement("insert into Buildings values(?,?,?,?,?)");
            )
        {
            prs.setInt(1, newBuildingNo);
            prs.setString(2, newBuildingName);
            prs.setString(3, newBuildingNameOfOwner);
            prs.setString(4, newBuildingType);
            prs.setString(5, newStreetId);
            
            int rowAffected = prs.executeUpdate();
            if(rowAffected > 0){
                isRegister=true;
            }
            
        }catch(SQLException sqle)
        {
            System.out.println(sqle.getMessage());
        }
        
        return isRegister;
    }
    
    public void checkBuildingInfo(int newBuildingId){
        
        try(
                Connection connect = Database.getMyConnection();
                PreparedStatement prs = connect.prepareStatement("select * from checkinfoview where ibuildingId = ?")
            )
        {
            prs.setInt(1, newBuildingId);
            ResultSet result = prs.executeQuery();
            result.next();
           
            setBuildingNo(result.getInt("iBuildingNo"));
            setBuildingName(result.getString("vBuildingname"));
            setBuildingNameOfOwner(result.getString("vBuildingNameOfOwner"));
            setBuildingType(result.getString("vBuildingType"));
            setStreetName(result.getString("vStreetName"));
            setDistrictName(result.getString("vDistrictName"));
            setLgaName(result.getString("vlgaName"));
            setStateName(result.getString("vstatename"));
            setCountryName(result.getString("vcountryName"));
            
        }catch(SQLException sqle){
            
            System.out.print(sqle.getMessage());
        }
    }
    
    public void checkAddress(int newBuildingId){
         try(
                Connection connect = Database.getMyConnection();
                PreparedStatement prs = connect.prepareStatement("select select ibuildingId, vbuildingName,iBuildingNo,vStreetName,vDistrictName,vlgaName,vStateName from checkinfoview where ibuildingId = ?")
            )
        {
            prs.setInt(1, newBuildingId);
            ResultSet result = prs.executeQuery();
            result.next();
           
            setBuildingName(result.getString("vBuildingname"));
            setBuildingNo(result.getInt("iBuildingNo"));
            setStreetName(result.getString("vStreetName"));
            setDistrictName(result.getString("vDistrictName"));
            setLgaName(result.getString("vlgaName"));
            setStateName(result.getString("vstatename"));
            
        }catch(SQLException sqle){
            
            System.out.print(sqle.getMessage());
        }
    }

    /**
     * @return the buildingId
     */
    public int getBuildingId() {
        return buildingId;
    }

    /**
     * @param buildingId the buildingId to set
     */
    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * @return the buildingNo
     */
    public int getBuildingNo() {
        return buildingNo;
    }

    /**
     * @param buildingNo the buildingNo to set
     */
    public void setBuildingNo(int buildingNo) {
        this.buildingNo = buildingNo;
    }

    /**
     * @return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * @param buildingName the buildingName to set
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * @return the buildingNameOfOwner
     */
    public String getBuildingNameOfOwner() {
        return buildingNameOfOwner;
    }

    /**
     * @param buildingNameOfOwner the buildingNameOfOwner to set
     */
    public void setBuildingNameOfOwner(String buildingNameOfOwner) {
        this.buildingNameOfOwner = buildingNameOfOwner;
    }

    /**
     * @return the buildingType
     */
    public String getBuildingType() {
        return buildingType;
    }

    /**
     * @param buildingType the buildingType to set
     */
    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
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

    /**
     * @return the districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName the districtName to set
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * @return the lgaName
     */
    public String getLgaName() {
        return lgaName;
    }

    /**
     * @param lgaName the lgaName to set
     */
    public void setLgaName(String lgaName) {
        this.lgaName = lgaName;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
    
}
