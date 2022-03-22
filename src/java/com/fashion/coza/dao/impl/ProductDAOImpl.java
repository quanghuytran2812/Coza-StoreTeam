/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.ProductDAO;
import com.fashion.coza.entity.Category;
import com.fashion.coza.entity.Product;
import com.fashion.coza.entity.ProductDetail;
import com.fashion.coza.jdbc.JDBCConnection;
import com.fashion.coza.service.CategoryService;
import com.fashion.coza.service.ProductDetailService;
import com.fashion.coza.service.impl.CategoryServiceImpl;
import com.fashion.coza.service.impl.ProductDetailServiceImpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class ProductDAOImpl extends JDBCConnection implements ProductDAO {

    CategoryService categortService = new CategoryServiceImpl();
    ProductDetailService pdetailService = new ProductDetailServiceImpl();

    @Override
    public void insert(Product product) {
        String sql = "insert into Product values(?, ?, ?, ?, ?, ?, ?)";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getPname());
            ps.setDouble(2, product.getPprice());
            ps.setInt(3, product.getPdiscount());
            ps.setBoolean(4, product.isPisNew());
            ps.setInt(5, product.getCid());
            ps.setString(6, product.getPdes());
            ps.setString(7, product.getPimg());

            System.out.println(product + ": dao product insert");

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fail to Product DAO insert ");
        }
    }

    @Override
    public void edit(Product product) {
        String sql = "update Product set pname = ?, pprice = ?, pdiscount = ?, pisNew = ?,cid = ?, pdes = ?, pimg = ? where pid = ?";
        Connection con = super.getJDBCConnection();
        System.out.println(product.getPdiscount() + ": product in dao");
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getPname());
            ps.setDouble(2, product.getPprice());
            ps.setInt(3, product.getPdiscount());
            ps.setBoolean(4, product.isPisNew());
            ps.setInt(5, product.getCid());
            ps.setString(6, product.getPdes());
            ps.setString(7, product.getPimg());
            ps.setInt(8, product.getPid());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//

    @Override
    public void delete(int pid) {
        String sql = "delete from Product where pid = ?";
        Connection con = super.getJDBCConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Product get(int pid) {

        String sql = "select * from Product join Category on Product.cid = Category.cid "
                + "join ProductDetail on Product.pid = ProductDetail.pid where Product.pid = ?";
        Connection con = super.getJDBCConnection();

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Category category = categortService.get(rs.getInt("cid"));
                ProductDetail pdetail = pdetailService.get(rs.getInt("pid"));

                Product product = new Product();

                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getLong("pprice"));
                product.setPdiscount(rs.getInt("pdiscount"));
                product.setPisNew(rs.getBoolean("pisNew"));
                product.setCid(rs.getInt("cid"));
                product.setPimg(rs.getString("pimg"));
                product.setPdes(rs.getString("pdes"));
                product.setPcate(category);
                product.setPdetail(pdetail);

                return product;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Fail to get single product dao");
        }
        return null;
    }

    @Override
    public List<Product> getAll() {

        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product join Category on Product.cid = Category.cid join ProductDetail on Product.pid = ProductDetail.pid";
        Connection conn = super.getJDBCConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Category category = categortService.get(rs.getInt("cid"));
                ProductDetail pdetail = pdetailService.get(rs.getInt("pid"));

                Product product = new Product();

                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getLong("pprice"));
                product.setPdiscount(rs.getInt("pdiscount"));
                product.setPisNew(rs.getBoolean("pisNew"));
                product.setCid(rs.getInt("cid"));
                product.setPimg(rs.getString("pimg"));
                product.setPdes(rs.getString("pdes"));
                product.setPcate(category);
                product.setPdetail(pdetail);

                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("get All product dao fail");
        }

        return productList;
    }

    @Override
    public List<Product> getAlls() {

        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product join Category on Product.cid = Category.cid ";
        Connection conn = super.getJDBCConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Category category = categortService.get(rs.getInt("cid"));

                Product product = new Product();

                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getLong("pprice"));
                product.setPdiscount(rs.getInt("pdiscount"));
                product.setPisNew(rs.getBoolean("pisNew"));
                product.setCid(rs.getInt("cid"));
                product.setPimg(rs.getString("pimg"));
                product.setPdes(rs.getString("pdes"));
                product.setPcate(category);

                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("get All product dao s fail");
        }

        return productList;
    }

    @Override
    public List<Product> getRelate(int cid) {

        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product join Category on Product.cid = Category.cid "
                + "join ProductDetail on Product.pid = ProductDetail.pid where Category.cid = ?";
        Connection conn = super.getJDBCConnection();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Category category = categortService.get(rs.getInt("cid"));
                ProductDetail pdetail = pdetailService.get(rs.getInt("pid"));

                Product product = new Product();

                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getLong("pprice"));
                product.setPdiscount(rs.getInt("pdiscount"));
                product.setPisNew(rs.getBoolean("pisNew"));
                product.setCid(rs.getInt("cid"));
                product.setPimg(rs.getString("pimg"));
                product.setPdes(rs.getString("pdes"));
                product.setPcate(category);
                product.setPdetail(pdetail);

                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("get All product dao fail");
        }

        return productList;
    }

    @Override
    public List<Product> seachByName(String productName) {
        List<Product> productList = new ArrayList<Product>();
        String sql = "select * from Product, Category where Product.cid = Category.cid and Product.pname like ? ";
        Connection conn = super.getJDBCConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + productName + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Category category = categortService.get(rs.getInt("cid"));
                
                Product product = new Product();

                product.setPid(rs.getInt("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getLong("pprice"));
                product.setPdiscount(rs.getInt("pdiscount"));
                product.setPisNew(rs.getBoolean("pisNew"));
                product.setCid(rs.getInt("cid"));
                product.setPimg(rs.getString("pimg"));
                product.setPdes(rs.getString("pdes"));
                product.setPcate(category);
                productList.add(product);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return productList;
    }

}
