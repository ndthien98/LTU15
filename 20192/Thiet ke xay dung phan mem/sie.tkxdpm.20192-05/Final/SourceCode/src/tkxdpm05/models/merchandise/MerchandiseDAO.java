/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.models.merchandise;

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
public class MerchandiseDAO implements Merchandise {

    @Override
    public ArrayList<MerchandiseDTO> readAll() {
        String sql = "SELECT * FROM `Merchandise`;";
        ResultSet rs = MySQLDB.getInstance().execResultQuerry(sql);
        ArrayList<MerchandiseDTO> list = new ArrayList<>();

        try {
            while (rs.next()) {
                MerchandiseDTO t = new MerchandiseDTO();
                t.setDescribe(rs.getString("describe"));
                t.setDispName(rs.getString("dispName"));
                t.setMerchandiseId(rs.getInt("merchandiseId"));
                t.setNote(rs.getString("note"));
                t.setPrice(rs.getInt("price"));
                t.setUnit(rs.getString("unit"));
                list.add(t);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(MerchandiseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean delete(MerchandiseDTO merchandiseDTO) {
        try {
            String sql = "DELETE FROM Merchandise WHERE "
                    + "merchandiseId = ? ;";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setInt(1, merchandiseDTO.getMerchandiseId());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MerchandiseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean update(MerchandiseDTO merchandiseDTO) {
        try {
            String sql = " UPDATE `Merchandise` SET "
                    + "`describe` = ? , "
                    + "`dispName` = ? , "
                    + "`note` = ? , "
                    + "`unit` = ? , "
                    + "`price` = ? "
                    + "WHERE `merchandiseId` = ?; ";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);
            prepareStatement.setString(1, merchandiseDTO.getDescribe());
            prepareStatement.setString(2, merchandiseDTO.getDispName());
            prepareStatement.setString(3, merchandiseDTO.getNote());
            prepareStatement.setString(4, merchandiseDTO.getUnit());
            prepareStatement.setInt(5, merchandiseDTO.getPrice());
            prepareStatement.setInt(6, merchandiseDTO.getMerchandiseId());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MerchandiseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean create(MerchandiseDTO merchandiseDTO) {
        try {
            String sql = " INSERT INTO `Merchandise`(`describe`,`dispName`,`note`,`unit`,`price`) VALUE ( ? , ? , ? , ? , ?);";
            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);

            prepareStatement.setString(1, merchandiseDTO.getDescribe());
            prepareStatement.setString(2, merchandiseDTO.getDispName());
            prepareStatement.setString(3, merchandiseDTO.getNote());
            prepareStatement.setString(4, merchandiseDTO.getUnit());
            prepareStatement.setInt(5, merchandiseDTO.getPrice());

            return prepareStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MerchandiseDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
//
//    @Override
//    public MerchandiseDTO read(int merchandiseId) {
//        try {
//            String sql = "SELECT * FROM `Merchandise` WHERE "
//                    + "`merchandiseId` = ? ; ";
//
//            PreparedStatement prepareStatement = MySQLDB.getInstance().getPrepareStatement(sql);
//
//            prepareStatement.setInt(1, merchandiseId);
//
//            ResultSet rs = prepareStatement.executeQuery();
//
//            if (rs.next()) {
//                MerchandiseDTO t = new MerchandiseDTO();
//                t.setMerchandiseId(rs.getInt("merchandiseId"));
//                t.setPrice(rs.getInt("price"));
//                t.setDescribe(rs.getString("describe"));
//                t.setDispName(rs.getString("dispName"));
//                t.setNote(rs.getString("note"));
//                t.setUnit(rs.getString("unit"));
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

//
//
//    @Override
//    public ArrayList<MerchandiseDTO> readAll() {
//       
//
//    }
}
