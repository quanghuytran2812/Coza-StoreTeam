/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller;

import com.fashion.coza.entity.User;
import com.fashion.coza.entity.Verify;
import com.fashion.coza.service.UserService;
import com.fashion.coza.service.VerifyService;
import com.fashion.coza.service.impl.UserServiceImpl;
import com.fashion.coza.service.impl.VerifyServiceImpl;
import com.fashion.coza.util.Constant;
import com.fashion.coza.util.Md5;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tuan anh
 */
@SuppressWarnings("serial")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath() + "/waiting");
            return;
        }

        // Check cookie
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/waiting");
                    return;
                }
            }
        }

        request.getRequestDispatcher(Constant.Path.LOGIN).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        VerifyService vservice = new VerifyServiceImpl();
        UserService service = new UserServiceImpl();
        User user = new User();

        String username = request.getParameter("uname");

        String password = request.getParameter("password");

        String vcode = request.getParameter("vcode");

        boolean isRememberMe = false;
        String remember = request.getParameter("remember");

        if ("on".equals(remember)) {
            isRememberMe = true;
        }

        String alertMsg = "";

        if (username.isEmpty() || password.isEmpty()) {
            alertMsg = "Username and password can't be empty!";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/view/client/login.jsp").forward(request, response);
            return;
        }

        Verify v = new Verify();

        v = vservice.getVcode(vcode);

        if (!vcode.equals(v.getCode())) {
            response.sendRedirect("/view/client/error.jsp");
            return;
        } else {

            String md5 = Md5.getMd5(password);
            user = service.login(username, md5);

        }

//        System.out.println(user);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);

            if (isRememberMe) {
                saveRemeberMe(response, username);
            }

            response.sendRedirect(request.getContextPath() + "/waiting");
        } else {
            alertMsg = "Username or password isn't correct";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("/view/client/login.jsp").forward(request, response);
        }
    }

    private void saveRemeberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER_USNAME, username);
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }
}
