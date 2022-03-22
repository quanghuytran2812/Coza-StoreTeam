/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.VerifyDAO;
import com.fashion.coza.entity.User;
import com.fashion.coza.entity.Verify;
import com.fashion.coza.jdbc.JDBCConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tuan anh
 */
public class VerifyDAOImpl extends JDBCConnection implements VerifyDAO {

    @Override
    public void insert(Verify verify) {

        String sql = "insert into Verify values(?, ?)";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, verify.getUid());
            ps.setString(2, verify.getCode());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String vcode) {

        String sql = "delete from [User] where vcode = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vcode);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Verify getVcode(String vcode) {

        String sql = "select * from Verify where vcode = ? ";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, vcode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Verify v = new Verify();

                v.setVid(rs.getInt("vid"));
                v.setUid(rs.getInt("uid"));
                v.setCode(rs.getString("vcode"));

                return v;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail to get Veify dao");
        }
        return null;

    }

}
