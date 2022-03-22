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
public class Category {

    private int cid;
    private String cname;
    private String csession;
    private String cimg;

    public Category() {
    }

    public Category(String cname, String csession, String cimg) {
        this.cname = cname;
        this.csession = csession;
        this.cimg = cimg;
    }

    public Category(int cid, String cname, String csession, String cimg) {
        this.cid = cid;
        this.cname = cname;
        this.csession = csession;
        this.cimg = cimg;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCsession() {
        return csession;
    }

    public void setCsession(String csession) {
        this.csession = csession;
    }

    public String getCimg() {
        return cimg;
    }

    public void setCimg(String cimg) {
        this.cimg = cimg;
    }

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", cname=" + cname + ", csession=" + csession + ", cimg=" + cimg + '}';
    }

}
