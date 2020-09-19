/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.Site;

import java.util.ArrayList;
import tkxdpm05.models.site.Site;
import tkxdpm05.models.site.SiteDAO;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public class SiteController {

    Site site;

    private SiteController() {
        site = new SiteDAO();
    }

    public static SiteController getInstance() {
        return SiteControllerHolder.INSTANCE;
    }

    ArrayList<SiteDTO> readAllSite() {
        return site.readAll();
    }

    boolean createSite(SiteDTO siteDTO) {
        return site.create(siteDTO);
    }

    boolean updateSite(SiteDTO siteDTO) {
        return site.update(siteDTO);

    }
    boolean deleteSite(SiteDTO siteDTO) {
        return site.delete(siteDTO);

    }

    private static class SiteControllerHolder {

        private static final SiteController INSTANCE = new SiteController();
    }
}
