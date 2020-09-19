/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.saleorder;

/**
 *
 * @author thiennd
 */
public class SaleOrderDTO {

    protected int saleOrderId;
    String status;
    String deliveryDesired;

    public SaleOrderDTO(int saleOrderId, String username, String status) {
        this.saleOrderId = saleOrderId;
        this.status = status;
    }

    public SaleOrderDTO() {
    }

    public int getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(int saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryDesired() {
        return deliveryDesired;
    }

    public void setDeliveryDesired(String deliveryDesired) {
        this.deliveryDesired = deliveryDesired;
    }

    @Override
    public String toString() {
        return "SaleOrderDTO{" + "saleOrderId=" + saleOrderId + ", createDay=" + ", status=" + status + ", deliveryDesired=" + deliveryDesired + '}';
    }

    public void update(SaleOrderDTO saleOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}