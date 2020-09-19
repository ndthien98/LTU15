/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.merchandise;


/**
 *
 * @author thiennd
 */
public class MerchandiseDTO {
    int merchandiseId;
    String dispName;
    String describe;
    String unit;
    String note;
    int price;

    public MerchandiseDTO() {
    }

    public MerchandiseDTO(int merchandiseId, String dispName, String describe, String unit, String note, int price) {
        this.merchandiseId = merchandiseId;
        this.dispName = dispName;
        this.describe = describe;
        this.unit = unit;
        this.note = note;
        this.price = price;
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public String getDispName() {
        return dispName;
    }

    public void setDispName(String dispName) {
        this.dispName = dispName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MerchandiseDTO{" + "merchandiseId=" + merchandiseId + ", dispName=" + dispName + ", describe=" + describe + ", unit=" + unit + ", note=" + note + ", price=" + price + '}';
    }
    
}
