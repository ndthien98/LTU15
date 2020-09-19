/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.ImportOrder;

import java.util.ArrayList;
import tkxdpm05.models.importorder.ImportOrder;
import tkxdpm05.models.importorder.ImportOrderDAO;
import tkxdpm05.models.importorder.ImportOrderDTO;
import tkxdpm05.models.merchandise.Merchandise;
import tkxdpm05.models.merchandise.MerchandiseDAO;
import tkxdpm05.models.provide.ProvideDTO;
import tkxdpm05.models.saleorder.SaleOrder;
import tkxdpm05.models.saleorder.SaleOrderDAO;
import tkxdpm05.models.saleorder.SaleOrderDTO;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;
import tkxdpm05.models.site.Site;
import tkxdpm05.models.site.SiteDAO;

/**
 *
 * @author thiennd
 */
public class ImportOrderController {

    ImportOrder importOrder;
    SaleOrder saleOrder;
    Merchandise merchandise;
    Site site;

    private ImportOrderController() {
        importOrder = new ImportOrderDAO();
        saleOrder = new SaleOrderDAO();
        site = new SiteDAO();
        merchandise = new MerchandiseDAO();
    }

    public static ImportOrderController getInstance() {
        return ImportOrderControllerHolder.INSTANCE;
    }

    ArrayList<ImportOrderDTO> readAllImportOrder() {
        return importOrder.readAll();
    }

    void updateImportOrder(ImportOrderDTO importOrderDTO) {
        importOrder.update(importOrderDTO);
    }

    ArrayList<SaleOrderDTO> readAllSaleOrder() {
        return saleOrder.readAll();
    }

    void createImportOrder(ImportOrderDTO importOrderDTO) {
        importOrder.create(importOrderDTO);
    }

    void updateSaleOrder(SaleOrderDTO saleOrderDTO) {
        saleOrder.update(saleOrderDTO);
    }

    ArrayList<ImportOrderDTO> generateImportOrder(SaleOrderDTO saleOrderDTO) {
        ArrayList<ImportOrderDTO> listImportOrderDTOs = new ArrayList<>();

        ArrayList<SaleOrderDetailDTO> listSaleOrderDetailDTOs = saleOrder.readDetail(saleOrderDTO);

        for (SaleOrderDetailDTO detail : listSaleOrderDetailDTOs) {

            ArrayList<ProvideDTO> listSiteProvide = site.readSiteProvide(detail);

            int quantity = detail.getQuantity();

            for (ProvideDTO provideDTO : listSiteProvide) {
                ImportOrderDTO importOrderDTO = new ImportOrderDTO();
                importOrderDTO.setImportOrderId(-1);

                importOrderDTO.setMerchandiseId(provideDTO.getMerchandiseId());
                if (provideDTO.getInstock() >= quantity) {
                    importOrderDTO.setQuantity(quantity);
                    quantity = 0;
                } else {
                    importOrderDTO.setQuantity(quantity);
                    quantity -= provideDTO.getInstock();
                }

                importOrderDTO.setSaleOrderId(detail.getSaleOrderId());

                importOrderDTO.setSiteId(provideDTO.getSiteId());
                importOrderDTO.setStatus("NEW");
                importOrderDTO.setDeliveryMean("2020-06-23");

                listImportOrderDTOs.add(importOrderDTO);
                if (quantity <= 0) {
                    break;
                }
            }

        }
        return listImportOrderDTOs;
    }

    private static class ImportOrderControllerHolder {

        private static final ImportOrderController INSTANCE = new ImportOrderController();
    }
}
