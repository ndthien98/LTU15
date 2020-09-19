/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.site;

import java.util.ArrayList;
import tkxdpm05.models.provide.ProvideDTO;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;

/**
 *
 * @author thiennd
 */
public interface Site {

    public ArrayList<SiteDTO> readAll();

    public boolean update(SiteDTO siteDTO);

    public boolean create(SiteDTO siteDTO);

    public boolean delete(SiteDTO siteDTO);

    public ArrayList<ProvideDTO> readSiteProvide(SaleOrderDetailDTO detail);


}
