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
public class ProductDetail {

    private int did;
    private int pid;
    private String pfimage;
    private String pbimage;
    private String pcimage;
    private String pcreated;
    private String pSKU;
    private String psize;
    private String pcolor;
    private Double pweight;
    private String pdismention;
    private String pmaterial;
    private String pdeslong;

    public ProductDetail() {
    }

    public ProductDetail(int pid, String pfimage, String pbimage, String pcimage, String pcreated, String pSKU, String psize, String pcolor, Double pweight, String pdismention, String pmaterial, String pdeslong) {
        this.pid = pid;
        this.pfimage = pfimage;
        this.pbimage = pbimage;
        this.pcimage = pcimage;
        this.pcreated = pcreated;
        this.pSKU = pSKU;
        this.psize = psize;
        this.pcolor = pcolor;
        this.pweight = pweight;
        this.pdismention = pdismention;
        this.pmaterial = pmaterial;
        this.pdeslong = pdeslong;
    }

    public ProductDetail(int did, int pid, String pfimage, String pbimage, String pcimage, String pcreated, String pSKU, String psize, String pcolor, Double pweight, String pdismention, String pmaterial, String pdeslong) {
        this.did = did;
        this.pid = pid;
        this.pfimage = pfimage;
        this.pbimage = pbimage;
        this.pcimage = pcimage;
        this.pcreated = pcreated;
        this.pSKU = pSKU;
        this.psize = psize;
        this.pcolor = pcolor;
        this.pweight = pweight;
        this.pdismention = pdismention;
        this.pmaterial = pmaterial;
        this.pdeslong = pdeslong;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPfimage() {
        return pfimage;
    }

    public void setPfimage(String pfimage) {
        this.pfimage = pfimage;
    }

    public String getPbimage() {
        return pbimage;
    }

    public void setPbimage(String pbimage) {
        this.pbimage = pbimage;
    }

    public String getPcimage() {
        return pcimage;
    }

    public void setPcimage(String pcimage) {
        this.pcimage = pcimage;
    }

    public String getPcreated() {
        return pcreated;
    }

    public void setPcreated(String pcreated) {
        this.pcreated = pcreated;
    }

    public String getpSKU() {
        return pSKU;
    }

    public void setpSKU(String pSKU) {
        this.pSKU = pSKU;
    }

    public String getPsize() {
        return psize;
    }

    public void setPsize(String psize) {
        this.psize = psize;
    }

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor;
    }

    public Double getPweight() {
        return pweight;
    }

    public void setPweight(Double pweight) {
        this.pweight = pweight;
    }

    public String getPdismention() {
        return pdismention;
    }

    public void setPdismention(String pdismention) {
        this.pdismention = pdismention;
    }

    public String getPmaterial() {
        return pmaterial;
    }

    public void setPmaterial(String pmaterial) {
        this.pmaterial = pmaterial;
    }

    public String getPdeslong() {
        return pdeslong;
    }

    public void setPdeslong(String pdeslong) {
        this.pdeslong = pdeslong;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "did=" + did + ", pid=" + pid + ", pfimage=" + pfimage + ", pbimage=" + pbimage + ", pcimage=" + pcimage + ", pcreated=" + pcreated + ", pSKU=" + pSKU + ", psize=" + psize + ", pcolor=" + pcolor + ", pweight=" + pweight + ", pdismention=" + pdismention + ", pmaterial=" + pmaterial + ", pdeslong=" + pdeslong + '}';
    }

}
