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
public class Product {

    private int pid;
    private String pname;
    private double pprice;
    private int pdiscount;
    private boolean pisNew;
    private int cid;
    private String pdes;
    private String pimg;
    private Category pcate;
    private ProductDetail pdetail;

    public Product() {
    }

    public Product(String pname, double pprice, int pdiscount, boolean pisNew, int cid, String pdes, String pimg, Category pcate, ProductDetail pdetail) {
        this.pname = pname;
        this.pprice = pprice;
        this.pdiscount = pdiscount;
        this.pisNew = pisNew;
        this.cid = cid;
        this.pdes = pdes;
        this.pimg = pimg;
        this.pcate = pcate;
        this.pdetail = pdetail;
    }

    public Product(int pid, String pname, double pprice, int pdiscount, boolean pisNew, int cid, String pdes, String pimg, Category pcate, ProductDetail pdetail) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.pdiscount = pdiscount;
        this.pisNew = pisNew;
        this.cid = cid;
        this.pdes = pdes;
        this.pimg = pimg;
        this.pcate = pcate;
        this.pdetail = pdetail;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public int getPdiscount() {
        return pdiscount;
    }

    public void setPdiscount(int pdiscount) {
        this.pdiscount = pdiscount;
    }

    public boolean isPisNew() {
        return pisNew;
    }

    public void setPisNew(boolean pisNew) {
        this.pisNew = pisNew;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPdes() {
        return pdes;
    }

    public void setPdes(String pdes) {
        this.pdes = pdes;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public Category getPcate() {
        return pcate;
    }

    public void setPcate(Category pcate) {
        this.pcate = pcate;
    }

    public ProductDetail getPdetail() {
        return pdetail;
    }

    public void setPdetail(ProductDetail pdetail) {
        this.pdetail = pdetail;
    }

    public Double getDisPrice() {

        return this.pprice - (this.pprice * this.pdiscount / 100);

    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pdiscount=" + pdiscount + ", pisNew=" + pisNew + ", cid=" + cid + ", pdes=" + pdes + ", pimg=" + pimg + ", pcate=" + pcate + ", pdetail=" + pdetail + '}';
    }

}
