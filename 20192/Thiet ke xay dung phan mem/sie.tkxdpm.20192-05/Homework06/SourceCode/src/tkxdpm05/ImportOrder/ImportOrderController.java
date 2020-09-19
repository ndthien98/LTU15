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
import tkxdpm05.models.merchandise.MerchandiseDTO;
import tkxdpm05.models.provide.Provide;
import tkxdpm05.models.provide.ProvideDAO;
import tkxdpm05.models.provide.ProvideDTO;
import tkxdpm05.models.saleorder.SaleOrder;
import tkxdpm05.models.saleorder.SaleOrderDAO;
import tkxdpm05.models.saleorder.SaleOrderDTO;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;
import tkxdpm05.models.site.Site;
import tkxdpm05.models.site.SiteDAO;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public class ImportOrderController {

    ImportOrder importOrder;
    SaleOrder saleOrder;
    Merchandise merchandise;
    Site site;
    Provide provide;

    private ImportOrderController() {
        importOrder = new ImportOrderDAO();
        saleOrder = new SaleOrderDAO();
        site = new SiteDAO();
        merchandise = new MerchandiseDAO();
        provide = new ProvideDAO();
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

    ArrayList<MerchandiseDTO> readAllMerchandise() {
        return merchandise.readAll();
    }

    ArrayList<SaleOrderDetailDTO> readAllSaleOrderDetail(SaleOrderDTO saleOrderDTO) {
        return saleOrder.readDetail(saleOrderDTO);
    }

    ArrayList<ProvideDTO> readAllProvide() {
        return provide.readAll();
    }

    ArrayList<SiteDTO> readAllSite() {
        return site.readAll();
    }

    void createImportOrder(ImportOrderDTO importOrderDTO) {
        importOrder.create(importOrderDTO);
    }

    void updateSaleOrder(SaleOrderDTO saleOrderDTO) {
        saleOrder.update(saleOrderDTO);
    }

    private static class ImportOrderControllerHolder {

        private static final ImportOrderController INSTANCE = new ImportOrderController();
    }
}
