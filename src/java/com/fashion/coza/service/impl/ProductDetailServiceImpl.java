/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.ProductDetailDAO;
import com.fashion.coza.dao.impl.ProductDetailDAOImpl;
import com.fashion.coza.entity.ProductDetail;
import com.fashion.coza.service.ProductDetailService;

/**
 *
 * @author tuan anh
 */
public class ProductDetailServiceImpl implements ProductDetailService {

    ProductDetailDAO pdetailDao = new ProductDetailDAOImpl();

    @Override
    public ProductDetail get(int pid) {
        return pdetailDao.get(pid);
    }

}
