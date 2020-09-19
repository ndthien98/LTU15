/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.site;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tkxdpm05.database.MySQLDB;
import tkxdpm05.models.provide.ProvideDTO;
import tkxdpm05.models.saleorder.SaleOrderDetailDTO;

/**
 *
 * @author thiennd
 */
public class SiteDAO implements Site {

    @Override
    public boolean create(SiteDTO siteDTO) {
        try {
            String sql = " INSERT INTO Site(address,shipDay,airDay,other,dispName) VALUE ( ? , ? , ? , ?, ?);";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, siteDTO.getAddress());
            prepareStatement.setInt(2, siteDTO.getShipDay());
            prepareStatement.setInt(3, siteDTO.getAirDay());
            prepareStatement.setString(4, siteDTO.getOther());
            prepareStatement.setString(5, siteDTO.getDispName());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
//
//    @Override
//    public SiteDTO read(int siteId) {
//        try {
//            String sql = "SELECT * FROM `Site` WHERE "
//                    + "`siteId` = ? ; ";
//
//            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);
//
//            prepareStatement.setInt(1, siteId);
//
//            ResultSet rs = prepareStatement.executeQuery();
//
//            if (rs.next()) {
//                SiteDTO t = new SiteDTO();
//                t.setAddress(rs.getString("address"));
//                t.setAirDay(rs.getString("airDay"));
//                t.setDispName(rs.getString("dispName"));
//                t.setOther(rs.getString("other"));
//                t.setShipDay(rs.getString("shipDay"));
//                t.setSiteId(rs.getInt("siteId"));
//                t.setUsername(rs.getString("username"));
//                return t;
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        };
//        return null;
//
//    }
//

    @Override
    public boolean update(SiteDTO siteDTO) {
        try {
            String sql = " UPDATE Site SET "
                    + "address = ? , "
                    + "shipDay = ? , "
                    + "airDay = ? , "
                    + "other = ? , "
                    + "dispName = ? "
                    + "WHERE siteId = ?; ";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, siteDTO.getAddress());
            prepareStatement.setInt(2, siteDTO.getShipDay());
            prepareStatement.setInt(3, siteDTO.getAirDay());
            prepareStatement.setString(4, siteDTO.getOther());
            prepareStatement.setString(5, siteDTO.getDispName());
            prepareStatement.setInt(6, siteDTO.getSiteId());

            return prepareStatement.execute();
        } catch (SQLException ex) {

            return false;
        }

    }
//

    @Override
    public boolean delete(SiteDTO siteDTO) {
        try {
            String sql = "DELETE FROM `Site` WHERE "
                    + "siteId = ? ;";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, siteDTO.getSiteId());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
//

    @Override
    public ArrayList<SiteDTO> readAll() {
        String sql = "SELECT * FROM `Site`;";
        ResultSet rs = MySQLDB.getInstance().execResultQuerry(sql);
        ArrayList<SiteDTO> listSite = new ArrayList<>();

        try {
            while (rs.next()) {
                SiteDTO t = new SiteDTO();

                t.setAddress(rs.getString("address"));
                t.setAirDay(rs.getInt("airDay"));
                t.setDispName(rs.getString("dispName"));
                t.setOther(rs.getString("other"));
                t.setShipDay(rs.getInt("shipDay"));
                t.setSiteId(rs.getInt("siteId"));

                listSite.add(t);
            }
            return listSite;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }

    }

    @Override
    public ArrayList<ProvideDTO> readSiteProvide(SaleOrderDetailDTO detail) {

        String sql
                = "select Provide.provideId, Provide.siteId, Provide.merchandiseId, Provide.instock "
                + "from Site, Provide "
                + "where Site.shipDay>0 and Site.airDay>0 "
                + "and Site.siteId = Provide.siteId "
                + "and Provide.merchandiseId = ? "
                + "and "
                + "( "
                + "	select sum(instock)  "
                + "	from Site, Provide "
                + "	where shipDay>0 or airDay>0 "
                + "	and Site.siteId = Provide.siteId "
                + "	and merchandiseId= ?  "
                + ") > ? "
                + "order by Provide.instock desc, shipDay asc, airDay asc"
                + ";";

        try {
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, detail.getMerchandiseId());
            prepareStatement.setInt(2, detail.getMerchandiseId());
            prepareStatement.setInt(3, detail.getQuantity() - 1);

            ResultSet rs = prepareStatement.executeQuery();

            ArrayList<ProvideDTO> listSite = new ArrayList<>();
            while (rs.next()) {
                ProvideDTO t = new ProvideDTO();
                t.setInstock(rs.getInt("instock"));
                t.setMerchandiseId(rs.getInt("merchandiseId"));
                t.setProvideId(rs.getInt("provideId"));
                t.setSiteId(rs.getInt("siteId"));
                listSite.add(t);
            }
            return listSite;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(SiteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }

    }

}
