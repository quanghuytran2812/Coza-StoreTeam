/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.CartItemDAO;
import com.fashion.coza.dao.ProductDAO;
import com.fashion.coza.dao.UserDAO;
import com.fashion.coza.entity.Cart;
import com.fashion.coza.entity.CartItem;
import com.fashion.coza.entity.Product;
import com.fashion.coza.entity.User;
import com.fashion.coza.jdbc.JDBCConnection;
import com.fashion.coza.service.CartService;
import com.fashion.coza.service.ProductService;
import com.fashion.coza.service.impl.CartServiceImpl;
import com.fashion.coza.service.impl.ProductServiceImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class CartItemDAOImpl extends JDBCConnection implements CartItemDAO {

    CartService cartService = new CartServiceImpl();
    ProductService productService = new ProductServiceImpl();
    UserDAO userDao = new UserDAOImpl();
    ProductDAO productDao = new ProductDAOImpl();

    @Override
    public void insert(CartItem cartItem) {
        String sql = "insert into CartItem values(?, ?, ?, ?, ?)";
        Connection con = super.getJDBCConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cartItem.getIid());
            ps.setInt(2, cartItem.getIquantity());
            ps.setDouble(3, cartItem.getProduct().getDisPrice());
            ps.setInt(4, cartItem.getProduct().getPid());
            ps.setString(5, cartItem.getCart().getKid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//
//    @Override
//    public void edit(CartItem cartItem) {
//        String sql = "UPDATE CartItem SET cat_id = ?, pro_id = ?, quantity = ?, unitPrice=? WHERE id = ?";
//        Connection con = super.getJDBCConnection();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, cartItem.getCart().getId());
//            ps.setInt(2, cartItem.getProduct().getId());
//            ps.setInt(3, cartItem.getQuantity());
//            ps.setLong(4, cartItem.getUnitPrice());
//            ps.setString(5, cartItem.getId());
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(String id) {
//        String sql = "DELETE FROM CartItem WHERE id = ?";
//        Connection con = super.getJDBCConnection();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public CartItem get(int id) {
//        String sql = "SELECT " + "CartItem.id, " + "CartItem.quantity, " + "CartItem.unitPrice, " + "cart.u_id, "
//                + "cart.buyDate, " + "product.name, " + "product.price " + "FROM CartItem " + "INNER JOIN Cart "
//                + "ON CartItem.cart_id = cart.id " + "INNER JOIN Product " + "ON CartItem.pro_id = Product.id "
//                + "WHERE CartItem.id = ?";
//        Connection con = super.getJDBCConnection();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                User user = userDao.get(rs.getInt("u_id"));
//                Cart cart = new Cart();
//                cart.setBuyer(user);
//                cart.setBuyDate(rs.getDate("buyDate"));
//                Product product = new Product();
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getLong("price"));
//                CartItem cartItem = new CartItem();
//                cartItem.setCart(cart);
//                cartItem.setProduct(product);
//                cartItem.setQuantity(rs.getInt("quantity"));
//                cartItem.setUnitPrice(rs.getLong("unitPrice"));
//                return cartItem;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
    @Override
    public List<CartItem> getAll() {
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        String sql = "select * from Cart join CartItem on Cart.kid = CartItem.kid ";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = userDao.get(rs.getInt("uid"));
                Cart cart = new Cart();
                cart.setKid(rs.getString("kid"));
                cart.setUser(user);
                cart.setKbuyDate(rs.getDate("kbuyDate"));
                
                Product product = productDao.get(rs.getInt("pid"));
                               
                CartItem cartItem = new CartItem();
                cartItem.setIid(rs.getString("iid"));
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setIquantity(rs.getInt("iquantity"));
                cartItem.setIunitPrice(rs.getLong("iunitPrice"));
                cartItemList.add(cartItem);
                System.out.println(cartItem.getCart());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItemList;
    }
//
//    public List<CartItem> search(String name) {
//        return null;
//    }
//
//    @Override
//    public CartItem get(String name) {
//        return null;
//    }
}
