/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao;

import com.fashion.coza.entity.Product;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public interface ProductDAO {

    void insert(Product product);

    void edit(Product product);
//

    void delete(int pid);
//

    Product get(int pid);
//

    List<Product> getAll();

    List<Product> getAlls();

    List<Product> getRelate(int cid);
//
//    List<Product> search(String username);
//
//    List<Product> seachByCategory(int cate_id);
//

    List<Product> seachByName(String productName);
}
