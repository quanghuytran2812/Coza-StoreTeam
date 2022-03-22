/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.CartDAO;
import com.fashion.coza.entity.Cart;
import com.fashion.coza.jdbc.JDBCConnection;
import com.fashion.coza.service.UserService;
import com.fashion.coza.service.impl.UserServiceImpl;
import java.sql.*;
/**
 *
 * @author tuan anh
 */
public class CartDAOImpl extends JDBCConnection implements CartDAO {

    UserService userS = new UserServiceImpl();

    @Override
    public void insert(Cart cart) {
        String sql = "insert into Cart values(?, ?, ?)";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cart.getKid());
            ps.setInt(2, cart.getUser().getUid());
            ps.setDate(3, new Date(cart.getKbuyDate().getTime()));
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void edit(Cart cart) {
//        String sql = "UPDATE cart SET id_user = ?, buyDate = ? WHERE id = ?";
//        Connection con = super.getJDBCConnection();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, cart.getBuyer().getId());
//            ps.setDate(2, new Date(cart.getBuyDate().getTime()));
//            ps.setString(3, cart.getId());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(int id) {
//        String sql = "DELETE FROM cart WHERE id = ?";
//        Connection con = super.getJDBCConnection();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Cart get(int id) {
//        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
//                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id WHERE cart.id=?";
//        Connection con = super.getJDBCConnection();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                User user = userS.get(rs.getInt("user_id"));
//
//                Cart cart = new Cart();
//                cart.setId(rs.getString("id"));
//                cart.setBuyDate(rs.getDate("buyDate"));
//                cart.setBuyer(user);
//                return cart;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Cart> getAll() {
//        List<Cart> cartList = new ArrayList<Cart>();
//        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
//                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id";
//        Connection con = super.getJDBCConnection();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                User user = userS.get(rs.getInt("user_id"));
//
//                Cart cart = new Cart();
//                cart.setId(rs.getString("id"));
//                cart.setBuyDate(rs.getDate("buyDate"));
//                cart.setBuyer(user);
//
//                cartList.add(cart);
//
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return cartList;
//    }
//
//    public List<Cart> search(String name) {
//        List<Cart> cartList = new ArrayList<Cart>();
//        String sql = "SELECT cart.id, cart.buyDate, User.email, user.username, user.id AS user_id "
//                + "FROM cart INNER JOIN user " + "ON cart.id_user = user.id LIKE User.email = ?";
//        Connection con = super.getJDBCConnection();
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User user = userS.get(rs.getInt("user_id"));
//                Cart cart = new Cart();
//                cart.setId(rs.getString("id"));
//                cart.setBuyDate(rs.getDate("buyDate"));
//                cart.setBuyer(user);
//                cartList.add(cart);
//
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return cartList;
//    }
//
//    @Override
//    public Cart get(String name) {
//        // TODO Auto-generated method stub
//        return null;
//    }
}
