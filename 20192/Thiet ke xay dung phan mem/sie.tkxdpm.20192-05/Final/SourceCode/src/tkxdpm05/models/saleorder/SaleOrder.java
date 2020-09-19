/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.saleorder;

import java.util.ArrayList;

/**
 *
 * @author thiennd
 */
public interface SaleOrder {

    public ArrayList<SaleOrderDTO> readAll();

    public boolean delete(SaleOrderDTO saleOrderDTO);

    public boolean create(SaleOrderDTO saleOrderDTO);

    public ArrayList<SaleOrderDetailDTO> readDetail(SaleOrderDTO saleOrderDTO);

    public void deleteSaleOrderDetail(SaleOrderDetailDTO saleOrderDetailDTO);

    public void createSaleOrderDetailDTO(SaleOrderDetailDTO saleOrderDetailDTO);

    public void updateSaleOrderDetailDTO(SaleOrderDetailDTO saleOrderDetailDTO);

    public void update(SaleOrderDTO saleOrderDTO);

   
}
