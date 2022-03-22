/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.CategoryDAO;
import com.fashion.coza.entity.Category;
import com.fashion.coza.jdbc.JDBCConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class CategoryDAOImpl extends JDBCConnection implements CategoryDAO {

    @Override
    public void insert(Category category) {
        String sql = "insert into Category values(?, ?, ?)";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCname());
            ps.setString(2, category.getCsession());
            ps.setString(3, category.getCimg());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Category category) {
        String sql = "update Category set cname = ?, csession = ?, cimg = ? where cid = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getCname());
            ps.setString(2, category.getCsession());
            ps.setString(3, category.getCimg());
            ps.setInt(4, category.getCid());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//

    @Override
    public void delete(int cid) {
        String sql = "delete from Category where cid = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int cid) {

        String sql = "select * from Category where cid = ? ";
        Connection con = super.getJDBCConnection();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                category.setCsession(rs.getString("csession"));
                category.setCimg(rs.getString("cimg"));

                return category;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Get Category by ID fail");
        }
        return null;
    }

    @Override
    public List<Category> getAll() {

        List<Category> categories = new ArrayList<Category>();
        String sql = "SELECT * FROM Category";

        Connection conn = super.getJDBCConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category();

                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                category.setCsession(rs.getString("csession"));
                category.setCimg(rs.getString("cimg"));

                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail to get All Category dao");
        }

        return categories;
    }

//    @Override
//    public List<Category> search(String keyword) {
//        List<Category> categories = new ArrayList<Category>();
//        String sql = "SELECT * FROM category WHERE name LIKE ? ";
//        Connection conn = super.getJDBCConnection();
//
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, "%" + keyword + "%");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Category category = new Category();
//
//                category.setId(rs.getInt("id"));
//                category.setName(rs.getString("name"));
//
//                categories.add(category);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return categories;
//    }
//    @Override
//    public Category get(String name) {
//        String sql = "SELECT * FROM Category WHERE cate_name = ? ";
//        Connection con = super.getJDBCConnection();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, name);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Category category = new Category();
//
//                category.setId(rs.getInt("cate_id"));
//                category.setName(rs.getString("cate_name"));
//
//                return category;
//
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
//    }
}
