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
public class Verify {

    private int vid;
    private int uid;
    private String code;

    public Verify() {
    }

    public Verify(int uid, String code) {
        this.uid = uid;
        this.code = code;
    }

    public Verify(int vid, int uid, String code) {
        this.vid = vid;
        this.uid = uid;
        this.code = code;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Verify{" + "vid=" + vid + ", uid=" + uid + ", code=" + code + '}';
    }

}
