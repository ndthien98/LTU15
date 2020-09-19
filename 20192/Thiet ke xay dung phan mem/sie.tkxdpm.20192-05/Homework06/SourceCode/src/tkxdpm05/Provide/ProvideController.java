/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.Provide;

import java.util.ArrayList;
import tkxdpm05.models.merchandise.Merchandise;
import tkxdpm05.models.merchandise.MerchandiseDAO;
import tkxdpm05.models.merchandise.MerchandiseDTO;
import tkxdpm05.models.provide.Provide;
import tkxdpm05.models.provide.ProvideDAO;
import tkxdpm05.models.provide.ProvideDTO;
import tkxdpm05.models.site.Site;
import tkxdpm05.models.site.SiteDAO;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public class ProvideController {

    Merchandise merchandise;
    Site site;
    Provide provide;

    private ProvideController() {
        merchandise = new MerchandiseDAO();
        site = new SiteDAO();
        provide = new ProvideDAO();
    }

    public static ProvideController getInstance() {
        return ProvideControllerHolder.INSTANCE;
    }

    ArrayList<SiteDTO> readAllSite() {
        return site.readAll();
    }

    ArrayList<ProvideDTO> readAllProvide() {
        return provide.readAll();
    }

    ArrayList<MerchandiseDTO> readAllMerchandise() {
        return merchandise.readAll();
    }

    boolean createProvide(ProvideDTO p) {
        return provide.create(p);
    }

    void deleteProvide(ProvideDTO provideDTO) {
        provide.delete(provideDTO);
    }

    private static class ProvideControllerHolder {

        private static final ProvideController INSTANCE = new ProvideController();
    }
}
