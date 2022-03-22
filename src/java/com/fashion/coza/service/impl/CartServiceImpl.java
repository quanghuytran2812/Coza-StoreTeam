/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.CartDAO;
import com.fashion.coza.dao.impl.CartDAOImpl;
import com.fashion.coza.entity.Cart;
import com.fashion.coza.service.CartService;

/**
 *
 * @author tuan anh
 */
public class CartServiceImpl implements CartService {

    CartDAO cartDao = new CartDAOImpl();

//    @Override
//    public List<Cart> search(String name) {
//        return cartDao.search(name);
//    }
//
    @Override
    public void insert(Cart cart) {
        cartDao.insert(cart);

    }
//
//    @Override
//    public List<Cart> getAll() {
//        return cartDao.getAll();
//    }
//
//    @Override
//    public Cart get(int id) {
//        return cartDao.get(id);
//    }

//    @Override
//    public void edit(Cart newCart) {
//        Cart oldCart = cartDao.get(newCart.getId());
//
//        oldCart.setBuyDate(newCart.getBuyDate());
//        oldCart.setBuyer(newCart.getBuyer());
//
//        cartDao.edit(oldCart);
//
//    }

//    @Override
//    public void delete(int id) {
//        cartDao.delete(id);
//    }

}
