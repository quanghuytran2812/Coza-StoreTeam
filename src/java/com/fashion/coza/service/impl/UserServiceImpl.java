/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.UserDAO;
import com.fashion.coza.dao.impl.UserDAOImpl;
import com.fashion.coza.entity.User;
import com.fashion.coza.service.UserService;
import java.io.File;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class UserServiceImpl implements UserService {

    UserDAO userDao = new UserDAOImpl();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void edit(User newUser) {
        User oldUser = userDao.get(newUser.getUid());

        oldUser.setUemail(newUser.getUemail());
        oldUser.setUsname(newUser.getUsname());
        oldUser.setUpassword(newUser.getUpassword());
        oldUser.setUrole(newUser.isUrole());
        if (newUser.getUavatar() != null) {
            // XOA ANH CU DI
            String fileName = oldUser.getUavatar();
            final String dir = "D:\\Project code Thue FPT\\CozaStoreFashion\\build\\web\\pics";
            File file = new File(dir + "/" + fileName);
            if (file.exists()) {
                file.delete();
            }
            // THEM ANH MOI
            oldUser.setUavatar(newUser.getUavatar());
        }

        userDao.edit(oldUser);
    }
//
    @Override
    public void delete(int uid) {
        userDao.delete(uid);
    }

    @Override
    public User get(String username) {
        return userDao.get(username);
    }
//
    @Override
    public User get(int id) {
        return userDao.get(id);
    }
//
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }
    
        @Override
    public List<User> getAllAdmin() {
        return userDao.getAllAdmin();
    }
//
//    @Override
//    public List<User> search(String username) {
//        return userDao.search(username);
//    }
//

    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getUpassword())) {
            return user;
        }

        return null;
    }

    @Override
    public boolean register(String email, String username, String password, String avt, boolean role) {
        if (userDao.checkExistUsername(username)) {
            return false;
        }
        userDao.insert(new User(email, username, password, avt, role));
        return true;
    }

    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

}
