/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service;

import com.fashion.coza.entity.Product;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public interface ProductService {

    void insert(Product product);

    void edit(Product product);
//

    void delete(int id);
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
