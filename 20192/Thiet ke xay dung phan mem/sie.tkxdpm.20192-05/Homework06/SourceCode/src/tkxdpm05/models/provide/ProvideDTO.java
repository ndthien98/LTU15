/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.provide;

/**
 *
 * @author thiennd
 */
public class ProvideDTO {

    int provideId;
    int siteId;
    int merchandiseId;
    int instock;

    public ProvideDTO() {
    }

    @Override
    public String toString() {
        return "ProvideDTO{" + "provideId=" + provideId + ", siteId=" + siteId + ", merchandiseId=" + merchandiseId + ", instock=" + instock + '}';
    }

    public int getProvideId() {
        return provideId;
    }

    public void setProvideId(int provideId) {
        this.provideId = provideId;
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

    public int getInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public ProvideDTO(int provideId, int siteId, int merchandiseId, int instock) {
        this.provideId = provideId;
        this.siteId = siteId;
        this.merchandiseId = merchandiseId;
        this.instock = instock;
    }

}
