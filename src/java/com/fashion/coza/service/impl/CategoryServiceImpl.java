/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.CategoryDAO;
import com.fashion.coza.dao.impl.CategoryDAOImpl;
import com.fashion.coza.entity.Category;
import com.fashion.coza.service.CategoryService;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDao = new CategoryDAOImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);

    }

    @Override
    public void edit(Category newCategory) {
        
        Category oldCate = categoryDao.get(newCategory.getCid());
        oldCate.setCname(newCategory.getCname());
        oldCate.setCsession(newCategory.getCsession());
        oldCate.setCimg(newCategory.getCimg());
        
        categoryDao.edit(oldCate);

    }
//
    @Override
    public void delete(int id) {
        categoryDao.delete(id);

    }
    
    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }
//
//    @Override
//    public Category get(String name) {
//        return categoryDao.get(name);
//    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }
//
//    @Override
//    public List<Category> search(String username) {
//        return categoryDao.search(username);
//    }

}
