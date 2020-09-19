/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.importorder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tkxdpm05.database.MySQLDB;

/**
 *
 * @author thiennd
 */
public class ImportOrderDAO implements ImportOrder {

    @Override
    public void create(ImportOrderDTO importOrderDTO) {
        try {// missing delivery mean at ? 7th posistion
            String sql = " INSERT INTO ImportOrder(status,deliveryMean,saleOrderId,siteId,merchandiseId,quantity) "
                    + "VALUE ( ? , ? , ? , ? , ? , ? );";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, importOrderDTO.getStatus());
            prepareStatement.setString(2, importOrderDTO.getDeliveryMean());
            prepareStatement.setInt(3, importOrderDTO.getSaleOrderId());
            prepareStatement.setInt(4, importOrderDTO.getSiteId());
            prepareStatement.setInt(5, importOrderDTO.getMerchandiseId());
            prepareStatement.setInt(6, importOrderDTO.getQuantity());

            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
//
//    @Override
//    public ImportOrderDTO read(int importOrderId) {
//
//        try {
//            String sql = "SELECT * FROM `ImportOrder` WHERE importOrderId = ?; ";
//            PreparedStatement preparedStatement = MySQLDB.getInstance().getPrepareStatement(sql);
//            preparedStatement.setInt(1, importOrderId);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                ImportOrderDTO t = new ImportOrderDTO();
//                t.setImportOrderId(rs.getInt("importOrderId"));
//                t.setUsername(rs.getString("username"));
//                t.setStatus(rs.getString("status"));
//                t.setDeliveryMean(rs.getString("deliveryMean"));
//                t.setSaleOrderId(rs.getInt("saleOrderId"));
//                t.setSiteId(rs.getInt("siteId"));
//                t.setMerchandiseId(rs.getInt("merchandiseId"));
//                t.setQuantity(rs.getInt("quantity"));
//                return t;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ImportOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//        return null;
//
//    }
//

    @Override
    public void update(ImportOrderDTO importOrderDTO) {
        //String sql = " INSERT INTO ImportOrder(,,,,,saleOrderId) VALUE ( ? , ? , ? , ? , ? , ?);";
        try {
            //,,,username,status,deliveryMean,saleOrderDetailId,siteId,merchandiseId,quantity
            String sql = " UPDATE ImportOrder SET "
                    + "status = ? , "
                    + "deliveryMean = ? , "
                    + "saleOrderId = ? , "
                    + "siteId = ? , "
                    + "merchandiseId = ? , "
                    + "quantity = ? "
                    + "WHERE importOrderId = ?; ";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, importOrderDTO.getStatus());
            prepareStatement.setString(2, importOrderDTO.getDeliveryMean());
            prepareStatement.setInt(3, importOrderDTO.getSaleOrderId());
            prepareStatement.setInt(4, importOrderDTO.getSiteId());
            prepareStatement.setInt(5, importOrderDTO.getMerchandiseId());
            prepareStatement.setInt(6, importOrderDTO.getQuantity());
            prepareStatement.setInt(7, importOrderDTO.getImportOrderId());

            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
//
//    @Override
//    public boolean delete(ImportOrderDTO importOrderDTO) {
//        try {
//            
//            System.out.println(importOrderDTO);
//            String sql = "DELETE FROM `ImportOrder` WHERE "
//                    + "`importOrderId` = ? ;";
//            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);
//
//            prepareStatement.setInt(1, importOrderDTO.getImportOrderId());
//            return prepareStatement.execute();
//            
//        } catch (Exception ex) {
//            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//
//    }
//

    @Override
    public ArrayList<ImportOrderDTO> readAll() {
        String sql = "SELECT * FROM `ImportOrder`;";
        ResultSet rs = MySQLDB.getInstance().execResultQuerry(sql);
        ArrayList<ImportOrderDTO> list = new ArrayList<>();
        try {
            while (rs.next()) {
                ImportOrderDTO t = new ImportOrderDTO();
                t.setImportOrderId(rs.getInt("importOrderId"));
                t.setStatus(rs.getString("status"));
                t.setDeliveryMean(rs.getString("deliveryMean"));
                t.setSaleOrderId(rs.getInt("saleOrderId"));
                t.setSiteId(rs.getInt("siteId"));
                t.setMerchandiseId(rs.getInt("merchandiseId"));
                t.setQuantity(rs.getInt("quantity"));
                list.add(t);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(ImportOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

}
