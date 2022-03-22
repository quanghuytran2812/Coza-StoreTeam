/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service;

import com.fashion.coza.entity.CartItem;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public interface CartItemService {

    void insert(CartItem cartItem);

//    void edit(CartItem cartItem);
//
//    void delete(String id);
//
//    CartItem get(int id);
//
    List<CartItem> getAll();
//
//    List<CartItem> search(String keyword);
}
