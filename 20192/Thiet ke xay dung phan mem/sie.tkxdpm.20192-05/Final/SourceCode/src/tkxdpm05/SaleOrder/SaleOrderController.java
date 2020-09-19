/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.SaleOrder;

import java.util.ArrayList;
import tkxdpm05.models.merchandise.Merchandise;
import tkxdpm05.models.merchandise.MerchandiseDAO;
import tkxdpm05.models.merchandise.MerchandiseDTO;
import tkxdpm05.models.saleorder.SaleOrder;
import tkxdpm05.models.saleorder.SaleOrderDAO;
import tkxdpm05.models.saleorder.SaleOrderDTO;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;

/**
 *
 * @author thiennd
 */
public class SaleOrderController {

    SaleOrder saleOrder;
    Merchandise merchandise;

    private SaleOrderController() {
        saleOrder = new SaleOrderDAO();
        merchandise = new MerchandiseDAO();
    }

    public static SaleOrderController getInstance() {
        return SaleOrderControllerHolder.INSTANCE;
    }

    ArrayList<SaleOrderDTO> readAllSaleOrder() {
        return saleOrder.readAll();
    }

    void deleteSaleOrder(SaleOrderDTO saleOrderDTO) {
        saleOrder.delete(saleOrderDTO);
    }

    ArrayList<MerchandiseDTO> readAllMerchandise() {
        return merchandise.readAll();
    }

    boolean createSaleOrder(SaleOrderDTO saleOrderDTO) {
        return saleOrder.create(saleOrderDTO);
    }

    ArrayList<SaleOrderDetailDTO> readSaleOrderDetail(SaleOrderDTO saleOrderDTO) {
        return saleOrder.readDetail(saleOrderDTO);
    }

    void deleteSaleOrderDetail(SaleOrderDetailDTO saleOrderDetailDTO) {
        saleOrder.deleteSaleOrderDetail(saleOrderDetailDTO);
    }

    void updateSaleOrderDetail(SaleOrderDetailDTO saleOrderDetailDTO) {
        saleOrder.updateSaleOrderDetailDTO(saleOrderDetailDTO);

    }

    void createSaleOrderDetail(SaleOrderDetailDTO saleOrderDetailDTO) {
        saleOrder.createSaleOrderDetailDTO(saleOrderDetailDTO);

    }

    private static class SaleOrderControllerHolder {

        private static final SaleOrderController INSTANCE = new SaleOrderController();
    }
}
