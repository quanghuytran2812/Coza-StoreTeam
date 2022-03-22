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
public class User {

    private int uid;
    private String uemail;
    private String usname;
    private String upassword;
    private String uavatar;
    private boolean urole;

    public User() {
    }

    public User(String uemail, String usname, String upassword, String uavatar, boolean urole) {
        this.uemail = uemail;
        this.usname = usname;
        this.upassword = upassword;
        this.uavatar = uavatar;
        this.urole = urole;
    }

    public User(int uid, String uemail, String usname, String upassword, String uavatar, boolean urole) {
        this.uid = uid;
        this.uemail = uemail;
        this.usname = usname;
        this.upassword = upassword;
        this.uavatar = uavatar;
        this.urole = urole;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUsname() {
        return usname;
    }

    public void setUsname(String usname) {
        this.usname = usname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUavatar() {
        return uavatar;
    }

    public void setUavatar(String uavatar) {
        this.uavatar = uavatar;
    }

    public boolean isUrole() {
        return urole;
    }

    public void setUrole(boolean urole) {
        this.urole = urole;
    }

    @Override
    public String toString() {
        return "User{" + "uid=" + uid + ", uemail=" + uemail + ", usname=" + usname + ", upassword=" + upassword + ", uavatar=" + uavatar + ", urole=" + urole + '}';
    }

}
