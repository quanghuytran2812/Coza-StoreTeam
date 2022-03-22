/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.VerifyDAO;
import com.fashion.coza.dao.impl.VerifyDAOImpl;
import com.fashion.coza.entity.Verify;
import com.fashion.coza.service.VerifyService;

/**
 *
 * @author tuan anh
 */
public class VerifyServiceImpl implements VerifyService {

    VerifyDAO verifyDao = new VerifyDAOImpl();
    
    @Override
    public void insert(Verify verify) {
        verifyDao.insert(verify);
    }

    @Override
    public void delete(String vcode) {
        verifyDao.delete(vcode);
    }

    @Override
    public Verify getVcode(String vcode) {
        return verifyDao.getVcode(vcode);
    }
    
    

}
