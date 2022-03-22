/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao.impl;

import com.fashion.coza.dao.ProductDetailDAO;
import com.fashion.coza.entity.ProductDetail;
import com.fashion.coza.jdbc.JDBCConnection;

import java.sql.*;

/**
 *
 * @author tuan anh
 */
public class ProductDetailDAOImpl extends JDBCConnection implements ProductDetailDAO {

    @Override
    public ProductDetail get(int did) {

        String sql = "select * from ProductDetail where pid = ? ";
        Connection con = super.getJDBCConnection();

        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, did);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductDetail pdetail = new ProductDetail();

                pdetail.setDid(rs.getInt("did"));
                pdetail.setPid(rs.getInt("pid"));
                pdetail.setPfimage(rs.getString("pfimage"));
                pdetail.setPbimage(rs.getString("pbimage"));
                pdetail.setPcimage(rs.getString("pcimage"));
                pdetail.setPcreated(rs.getString("pcreated"));
                pdetail.setpSKU(rs.getString("pSKU"));
                pdetail.setPsize(rs.getString("psize"));
                pdetail.setPcolor(rs.getString("pcolor"));
                pdetail.setPweight(rs.getDouble("pweight"));
                pdetail.setPdismention(rs.getString("pdismention"));
                pdetail.setPmaterial(rs.getString("pmaterial"));
                pdetail.setPdeslong(rs.getString("pdeslong"));

                return pdetail;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Get Product Detail dao by ID fail");
        }
        return null;
    }

}
