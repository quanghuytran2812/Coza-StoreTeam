/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service;

import com.fashion.coza.entity.User;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public interface UserService {

    void insert(User user);

    void edit(User user);
//

    void delete(int uid);
//

    User get(String username);
//

    User get(int id);
//

    User login(String username, String password);
//

    boolean register(String email, String password, String username, String avatar, boolean role);
//

    List<User> getAllUser();

    List<User> getAllAdmin();

//
//    List<User> search(String keyword);
//
    boolean checkExistEmail(String email);

    boolean checkExistUsername(String username);
}
