/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.provide;

import java.util.ArrayList;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public interface Provide {

    public ArrayList<ProvideDTO> readAll();

    public boolean create(ProvideDTO p);

    public boolean delete(ProvideDTO provideDTO);

}
