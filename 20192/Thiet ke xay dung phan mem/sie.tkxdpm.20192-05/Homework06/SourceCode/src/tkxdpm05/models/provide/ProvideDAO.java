/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.provide;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tkxdpm05.database.MySQLDB;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;
import tkxdpm05.models.site.SiteDTO;

/**
 *
 * @author thiennd
 */
public class ProvideDAO implements Provide {

    @Override
    public ArrayList<ProvideDTO> readAll() {
        String sql = "SELECT * FROM `Provide`;";
        ResultSet rs = MySQLDB.getInstance().execResultQuerry(sql);
        ArrayList<ProvideDTO> list = new ArrayList<>();

        try {
            while (rs.next()) {
                ProvideDTO t = new ProvideDTO();
                t.setInstock(rs.getInt("instock"));
                t.setMerchandiseId(rs.getInt("merchandiseId"));
                t.setProvideId(rs.getInt("provideId"));
                t.setSiteId(rs.getInt("siteId"));
                list.add(t);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(ProvideDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean create(ProvideDTO provideDTO) {

        try {
            String sql = " INSERT INTO `Provide`(`merchandiseId`,`siteId`,`instock`) VALUE ( ? , ? , ?);";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, provideDTO.getMerchandiseId());
            prepareStatement.setInt(2, provideDTO.getSiteId());
            prepareStatement.setInt(3, provideDTO.getInstock());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProvideDAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    @Override
    public boolean delete(ProvideDTO provideDTO) {
        try {
            String sql = "DELETE FROM `Provide` WHERE "
                    + "provideId = ? ;";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, provideDTO.getProvideId());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProvideDTO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
