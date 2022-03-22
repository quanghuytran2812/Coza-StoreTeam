/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.dao;

import com.fashion.coza.entity.User;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public interface UserDAO {

    void insert(User user);

    void edit(User user);
//

    void delete(int uid);
//

    User get(String username);
//

    User get(int id);
//

    List<User> getAllUser();

    List<User> getAllAdmin();
//
//    List<User> search(String username);
//

    boolean checkExistEmail(String email);
//

    boolean checkExistUsername(String username);
}
