/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkxdpm05.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import tkxdpm05.utils.ENV;

/**
 *
 * @author thiennd
 */
public class MySQLDB {

    private Connection connection = null;
    private Statement statement = null;
    private static MySQLDB instance;

    public static MySQLDB getInstance() {
        if (instance == null) {
            instance = new MySQLDB();
        }
        return instance;
    }

    private MySQLDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    ENV.DATABASE_LINK,
                    ENV.DB_USERNAME,
                    ENV.DB_PASSWORD);
            statement = connection.createStatement();
            System.out.println("Database connected!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ResultSet execResultQuerry(String sql) {
        System.out.println("rawSQL: " + sql);

        ResultSet rs = null;

        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public boolean execNonQuerry(String sql) {
        System.out.println("rawSQL: " + sql);

        try {
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public PreparedStatement getPrepareStatement(String prepareSQL) {
        System.out.println("preSQL: " + prepareSQL);
        try {
            return connection.prepareStatement(prepareSQL);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
