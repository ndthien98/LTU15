/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.site;

/**
 *
 * @author thiennd
 */
public class SiteDTO {

    int siteId;
    String dispName;
    String address;
    int shipDay;
    int airDay;
    String other;
   

    public SiteDTO(int siteId, String dispName, String address, int shipDay, int airDay, String other) {
        this.siteId = siteId;
        this.dispName = dispName;
        this.address = address;
        this.shipDay = shipDay;
        this.airDay = airDay;
        this.other = other;
    }

    public SiteDTO() {

    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getDispName() {
        return dispName;
    }

    public void setDispName(String dispName) {
        this.dispName = dispName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShipDay() {
        return shipDay;
    }

    public void setShipDay(int shipDay) {
        this.shipDay = shipDay;
    }

    public int getAirDay() {
        return airDay;
    }

    public void setAirDay(int airDay) {
        this.airDay = airDay;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "SiteDTO{" + "siteId=" + siteId + ", dispName=" + dispName + ", address=" + address + ", shipDay=" + shipDay + ", airDay=" + airDay + ", other=" + other + '}';
    }

}
