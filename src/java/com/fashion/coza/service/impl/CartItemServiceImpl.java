/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.CartItemDAO;
import com.fashion.coza.dao.impl.CartItemDAOImpl;
import com.fashion.coza.entity.CartItem;
import com.fashion.coza.service.CartItemService;
import java.util.*;

/**
 *
 * @author tuan anh
 */
public class CartItemServiceImpl implements CartItemService {

    CartItemDAO cartItemDao = new CartItemDAOImpl();

    @Override
    public void insert(CartItem cartItem) {
        cartItemDao.insert(cartItem);

    }

//    @Override
//    public void edit(CartItem newCartItem) {
//        CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
//        oldCartItem.setCart(newCartItem.getCart());
//        oldCartItem.setProduct(newCartItem.getProduct());
//        oldCartItem.setQuantity(newCartItem.getQuantity());
//        oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
//
//        cartItemDao.edit(oldCartItem);
//    }
//
//    @Override
//    public void delete(String id) {
//        cartItemDao.delete(id);
//    }
//
//    @Override
//    public CartItem get(int id) {
//        return cartItemDao.get(id);
//    }
//
    @Override
    public List<CartItem> getAll() {
        return cartItemDao.getAll();
    }
//
//    @Override
//    public List<CartItem> search(String keyword) {
//        return cartItemDao.search(keyword);
//    }
}
