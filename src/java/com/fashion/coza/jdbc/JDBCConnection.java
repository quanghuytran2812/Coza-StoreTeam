/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tuan anh
 */

public class JDBCConnection {

    public static Connection getJDBCConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String pass = "anhdn123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=CozaStoreFashion";
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Success To Connect DataBase!");

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Fail To Connect DataBase!");
        }

        return connection;
    }
}
