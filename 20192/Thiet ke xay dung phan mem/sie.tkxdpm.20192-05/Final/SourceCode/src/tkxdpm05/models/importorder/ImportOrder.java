/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.importorder;

import java.util.ArrayList;

/**
 *
 * @author thiennd
 */
public interface ImportOrder {

    public ArrayList<ImportOrderDTO> readAll();

    public void update(ImportOrderDTO importOrderDTO);

    public void create(ImportOrderDTO importOrderDTO);

}
