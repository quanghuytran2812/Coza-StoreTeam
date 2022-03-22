/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service;

import com.fashion.coza.entity.Category;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public interface CategoryService {

    void insert(Category category);

    void edit(Category category);
//

    void delete(int id);
//

    Category get(int id);
//
//    Category get(String name);
//

    List<Category> getAll();
//
//    List<Category> search(String username);
}
