/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author tuan anh
 */
@SuppressWarnings("serial")
public class Cart implements Serializable {

    private String kid;
    private User user;
    private Date kbuyDate;

    public Cart() {
    }

    public Cart(String kid, User user, Date kbuyDate) {
        this.kid = kid;
        this.user = user;
        this.kbuyDate = kbuyDate;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getKbuyDate() {
        return kbuyDate;
    }

    public void setKbuyDate(Date kbuyDate) {
        this.kbuyDate = kbuyDate;
    }

    @Override
    public String toString() {
        return "Cart{" + "kid=" + kid + ", user=" + user + ", kbuyDate=" + kbuyDate + '}';
    }

}
