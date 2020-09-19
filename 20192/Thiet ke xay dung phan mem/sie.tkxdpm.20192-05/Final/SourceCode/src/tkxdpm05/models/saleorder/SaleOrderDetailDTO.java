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
public class SaleOrderDetailDTO {
    int saleOrderDetailId;
    int saleOrderId;
    int merchandiseId;
    int quantity;

    public SaleOrderDetailDTO() {
    }

    public SaleOrderDetailDTO(int saleOrderDetailId, int saleOrderId, int merchandiseId, int quantity) {
        this.saleOrderDetailId = saleOrderDetailId;
        this.saleOrderId = saleOrderId;
        this.merchandiseId = merchandiseId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleOrderDetailDTO{" + "saleOrderDetailId=" + saleOrderDetailId + ", saleOrderId=" + saleOrderId + ", merchandiseId=" + merchandiseId + ", quantity=" + quantity + '}';
    }

    public int getSaleOrderDetailId() {
        return saleOrderDetailId;
    }

    public void setSaleOrderDetailId(int saleOrderDetailId) {
        this.saleOrderDetailId = saleOrderDetailId;
    }

    public int getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(int saleOrderId) {
        this.saleOrderId = saleOrderId;
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
    
    
    
}
