/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.UserDAO;
import com.fashion.coza.entity.User;
import com.fashion.coza.jdbc.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class UserDAOImpl extends JDBCConnection implements UserDAO {

    @Override
    public void insert(User user) {

        String sql = "insert into [User] values(?, ?, ?, ?, ?)";
        Connection con = super.getJDBCConnection();

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getUemail());
            ps.setString(2, user.getUsname());
            ps.setString(3, user.getUpassword());
            ps.setString(4, user.getUavatar());
            ps.setBoolean(5, user.isUrole());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail to insert User");
        }
    }

    @Override
    public void edit(User user) {

        String sql = "update [User] set uemail = ? , usname = ?, upassword = ?, uavatar = ?, urole = ? WHERE uid = ?";
        Connection con = super.getJDBCConnection();

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getUemail());
            ps.setString(2, user.getUsname());
            ps.setString(3, user.getUpassword());
            ps.setString(4, user.getUavatar());
            ps.setBoolean(5, user.isUrole());
            ps.setInt(6, user.getUid());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail to edit User dao");
        }
    }
//
    @Override
    public void delete(int uid) {
        String sql = "delete from [User] where uid = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, uid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//

    @Override
    public User get(String username) {
        String sql = "select * from [User] where usname = ? ";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = new User();

                user.setUid(rs.getInt("uid"));
                user.setUemail(rs.getString("uemail"));
                user.setUsname(rs.getString("usname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUavatar(rs.getString("uavatar"));
                user.setUrole(rs.getBoolean("urole"));

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail to get User Name dao");
        }
        return null;
    }
//

    @Override
    public User get(int id) {

        String sql = "select * from [User] where uid = ? ";
        Connection con = super.getJDBCConnection();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUemail(rs.getString("uemail"));
                user.setUsname(rs.getString("usname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUavatar(rs.getString("uavatar"));
                user.setUrole(rs.getBoolean("urole"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//

    @Override
    public List<User> getAllUser() {
        
        List<User> userList = new ArrayList<User>();
        String sql = "select * from [User] where urole = 0";
        
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUemail(rs.getString("uemail"));
                user.setUsname(rs.getString("usname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUavatar(rs.getString("uavatar"));
                user.setUrole(rs.getBoolean("urole"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    @Override
    public List<User> getAllAdmin() {
        
        List<User> userList = new ArrayList<User>();
        String sql = "select * from [User] where urole = 1";
        
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUemail(rs.getString("uemail"));
                user.setUsname(rs.getString("usname"));
                user.setUpassword(rs.getString("upassword"));
                user.setUavatar(rs.getString("uavatar"));
                user.setUrole(rs.getBoolean("urole"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
//
//    @Override
//    public List<User> search(String keyword) {
//        List<User> userList = new ArrayList<User>();
//        String sql = "SELECT * FROM [User] WHERE name LIKE ? ";
//        Connection conn = super.getJDBCConnection();
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, "%" + keyword + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setEmail(rs.getString("email"));
//                user.setUsername(rs.getString("username"));
//                user.setPassword(rs.getString("password"));
//                user.setAvatar(rs.getString("avatar"));
//                user.setRoleId(Integer.parseInt(rs.getString("role_id")));
//                userList.add(user);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return userList;
//    }

    public boolean checkExistEmail(String email) {

        boolean duplicate = false;
        Connection conn = JDBCConnection.getJDBCConnection();
        try {

            String query = "select * from [User] where uemail = ?";

            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, email);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                duplicate = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Fail to check exist email dao");
        }
        return duplicate;
    }

    public boolean checkExistUsername(String username) {

        boolean duplicate = false;
        Connection conn = JDBCConnection.getJDBCConnection();

        try {

            String query = "select * from [User] where usname = ? ";

            PreparedStatement psmt = conn.prepareStatement(query);
            psmt.setString(1, username);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                duplicate = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Fail to check exist username dao");
        }
        return duplicate;
    }

}
