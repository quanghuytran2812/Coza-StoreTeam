/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao;

import com.fashion.coza.entity.Verify;

/**
 *
 * @author tuan anh
 */
public interface VerifyDAO {
    
    void insert(Verify verify);
    
    void delete(String vcode);
 
    Verify getVcode(String vcode);
    
}
