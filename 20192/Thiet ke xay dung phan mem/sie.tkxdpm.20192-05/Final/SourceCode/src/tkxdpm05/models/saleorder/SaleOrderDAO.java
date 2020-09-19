/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.saleorder;

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
public class SaleOrderDAO implements SaleOrder {

    @Override
    public boolean create(SaleOrderDTO saleOrderDTO) {
        try {
            String sql = " INSERT INTO SaleOrder(status,deliveryDesired) VALUE ( ? , ? );";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, saleOrderDTO.getStatus());
            prepareStatement.setString(2, saleOrderDTO.getDeliveryDesired());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
//
//    @Override
//    public SaleOrderDTO read(int saleOrderId) {
//        try {
//            String sql = "SELECT * FROM `SaleOrder` WHERE "
//                    + "`saleOrderId` = ? ; ";
//
//            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);
//
//            prepareStatement.setInt(1, saleOrderId);
//
//            ResultSet rs = prepareStatement.executeQuery();
//
//            if (rs.next()) {
//                SaleOrderDTO t = new SaleOrderDTO();
//                t.setSaleOrderId(rs.getInt("saleOrderId"));
//                t.setStatus(rs.getString("status"));
//                t.setUsername(rs.getString("username"));
//                t.setDeliveryDesired(rs.getString("deliveryDesired"));
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
    public void update(SaleOrderDTO saleOrderDTO) {
        try {
            String sql = " UPDATE SaleOrder SET "
                    + "status = ? , "
                    + "deliveryDesired = ? "
                    + "WHERE saleOrderId = ?; ";
            
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, saleOrderDTO.getStatus());
            prepareStatement.setString(2, saleOrderDTO.getDeliveryDesired());
            prepareStatement.setInt(3, saleOrderDTO.getSaleOrderId());

            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
//

    @Override
    public boolean delete(SaleOrderDTO saleOrderDTO) {
        try {
            String sql = "DELETE FROM SaleOrder WHERE "
                    + "saleOrderId = ? ;";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, saleOrderDTO.getSaleOrderId());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }

    }
//

    @Override
    public ArrayList<SaleOrderDTO> readAll() {
        String sql = "SELECT * FROM `SaleOrder`;";
        ResultSet rs = MySQLDB.getInstance().execResultQuerry(sql);
        ArrayList<SaleOrderDTO> list = new ArrayList<>();

        try {
            while (rs.next()) {
                SaleOrderDTO t = new SaleOrderDTO();
                t.setSaleOrderId(rs.getInt("saleOrderId"));
                t.setStatus(rs.getString("status"));
                t.setDeliveryDesired(rs.getString("deliveryDesired"));
                list.add(t);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<SaleOrderDetailDTO> readDetail(SaleOrderDTO saleOrderDTO) {
        try {
            String sql = "SELECT * FROM `SaleOrderDetail` WHERE "
                    + "`saleOrderId` = ? ; ";

            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, saleOrderDTO.getSaleOrderId());

            ResultSet rs = prepareStatement.executeQuery();
            ArrayList<SaleOrderDetailDTO> list = new ArrayList<>();
            while (rs.next()) {
                SaleOrderDetailDTO t = new SaleOrderDetailDTO();
                t.setSaleOrderId(rs.getInt("saleOrderId"));
                t.setMerchandiseId(rs.getInt("merchandiseId"));
                t.setQuantity(rs.getInt("quantity"));
                t.setSaleOrderDetailId(rs.getInt("saleOrderDetailId"));
                list.add(t);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }

    }

    @Override
    public void deleteSaleOrderDetail(SaleOrderDetailDTO saleOrderDetailDTO) {
        try {
            String sql = "DELETE FROM SaleOrderDetail WHERE "
                    + "saleOrderDetailId = ? ;";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, saleOrderDetailDTO.getSaleOrderDetailId());

            prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    public void createSaleOrderDetailDTO(SaleOrderDetailDTO saleOrderDetailDTO) {
        try {
            String sql = " INSERT INTO SaleOrderDetail(saleOrderId,merchandiseId,quantity) VALUE ( ? , ? , ? );";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, saleOrderDetailDTO.getSaleOrderId());
            prepareStatement.setInt(2, saleOrderDetailDTO.getMerchandiseId());
            prepareStatement.setInt(3, saleOrderDetailDTO.getQuantity());

            prepareStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateSaleOrderDetailDTO(SaleOrderDetailDTO saleOrderDetailDTO) {
        try {
            String sql = " UPDATE SaleOrderDetail SET "
                    + "saleOrderId = ? , "
                    + "merchandiseId = ? , "
                    + "quantity = ? "
                    + "WHERE saleOrderDetailId = ?; ";

            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, saleOrderDetailDTO.getSaleOrderId());
            prepareStatement.setInt(2, saleOrderDetailDTO.getMerchandiseId());
            prepareStatement.setInt(3, saleOrderDetailDTO.getQuantity());
            prepareStatement.setInt(4, saleOrderDetailDTO.getSaleOrderDetailId());

            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
