/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.entity;

/**
 *
 * @author tuan anh
 */
public class CartItem {

    private String iid;
    private int iquantity;
    private double iunitPrice;
    private Product product;
    private Cart cart;

    public CartItem() {
    }

    public CartItem(String iid, int iquantity, double iunitPrice, Product product, Cart cart) {
        this.iid = iid;
        this.iquantity = iquantity;
        this.iunitPrice = iunitPrice;
        this.product = product;
        this.cart = cart;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public int getIquantity() {
        return iquantity;
    }

    public void setIquantity(int iquantity) {
        this.iquantity = iquantity;
    }

    public double getIunitPrice() {
        return iunitPrice;
    }

    public void setIunitPrice(double iunitPrice) {
        this.iunitPrice = iunitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartItem{" + "iid=" + iid + ", iquantity=" + iquantity + ", iunitPrice=" + iunitPrice + ", product=" + product + ", cart=" + cart + '}';
    }

}
