/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.Merchandise;

import java.util.ArrayList;
import tkxdpm05.models.merchandise.Merchandise;
import tkxdpm05.models.merchandise.MerchandiseDAO;
import tkxdpm05.models.merchandise.MerchandiseDTO;


/**
 *
 * @author thiennd
 */
public class MerchandiseController {

    Merchandise merchandise;

    private MerchandiseController() {
        merchandise = new MerchandiseDAO();
    }

    public static MerchandiseController getInstance() {
        return MerchandiseControllerHolder.INSTANCE;
    }

    ArrayList<MerchandiseDTO> readAll() {
        return merchandise.readAll();
    }

    boolean createMerchandise(MerchandiseDTO merchandiseDTO) {
        return merchandise.create(merchandiseDTO);
    }

    boolean updateMerchandise(MerchandiseDTO merchandiseDTO) {
        return merchandise.update(merchandiseDTO);

    }
    boolean deleteMerchandise(MerchandiseDTO merchandiseDTO) {
        return merchandise.delete(merchandiseDTO);

    }

    private static class MerchandiseControllerHolder {

        private static final MerchandiseController INSTANCE = new MerchandiseController();
    }
}
