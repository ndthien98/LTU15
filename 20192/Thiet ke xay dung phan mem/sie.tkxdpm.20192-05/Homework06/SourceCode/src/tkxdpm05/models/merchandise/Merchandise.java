/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.merchandise;

import java.util.ArrayList;

/**
 *
 * @author thiennd
 */
public interface Merchandise {

    public ArrayList<MerchandiseDTO> readAll();

    public boolean delete(MerchandiseDTO merchandiseDTO);

    public boolean update(MerchandiseDTO merchandiseDTO);

    public boolean create(MerchandiseDTO merchandiseDTO);

   

}
