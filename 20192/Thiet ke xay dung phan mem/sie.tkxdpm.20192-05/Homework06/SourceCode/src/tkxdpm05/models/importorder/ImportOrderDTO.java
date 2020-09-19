/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.importorder;

import java.sql.Date;

/**
 *
 * @author thiennd
 */
public class ImportOrderDTO {

    int importOrderId; // PK
    int saleOrderId; // FK
    String status;
    String deliveryMean;
    int siteId;
    int merchandiseId;
    int quantity;

    public ImportOrderDTO() {

    }

    public int getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(int saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(int merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImportOrderId() {
        return importOrderId;
    }

    public void setImportOrderId(int importOrderId) {
        this.importOrderId = importOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryMean() {
        return deliveryMean;
    }

    public void setDeliveryMean(String deliveryMean) {
        this.deliveryMean = deliveryMean;
    }

    @Override
    public String toString() {
        return "ImportOrderDTO{" + "importOrderId=" + importOrderId + ", saleOrderDetailId=" + saleOrderId + ", status=" + status + ", deliveryMean=" + deliveryMean + ", siteId=" + siteId + ", merchandiseId=" + merchandiseId + ", quantity=" + quantity + '}';
    }

}
