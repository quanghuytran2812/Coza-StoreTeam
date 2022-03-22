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
import com.fashion.coza.tools.SendEmail;
import com.fashion.coza.util.Constant;
import com.fashion.coza.util.Md5;
import com.fashion.coza.util.RandomUUID;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
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
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            response.sendRedirect(request.getContextPath() + "/admin");
            return;
        }
        // Check cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/admin");
                    return;
                }
            }
        }

        request.getRequestDispatcher(Constant.Path.REGISTER).forward(request, response);

    }

    @SuppressWarnings("static-access")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        String passConfirm = request.getParameter("passConfirm");

        Verify v = new Verify();
        UserService service = new UserServiceImpl();
        VerifyService vservice = new VerifyServiceImpl();

        String alertMsg = "";
        boolean isSuccess;

        if (service.checkExistEmail(email) || service.checkExistUsername(userName)) {
            alertMsg = "Email or UserName already exist!";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher(Constant.Path.REGISTER).forward(request, response);
            System.out.println(alertMsg);
            return;
        }

        if (password.equals(passConfirm)) {

            String md5 = Md5.getMd5(password);

            isSuccess = service.register(email, userName, md5, "default.png", false);

            if (isSuccess) {

                User u = service.get(userName);
                
                v.setUid(u.getUid());
                v.setCode(RandomUUID.getRandomID());
                vservice.insert(v);

                String message = "<!DOCTYPE html>\n"
                        + "\n"
                        + "<head>\n"
                        + "\n"
                        + "<body>\n"
                        + "<h3 style=\"color: blue;\" >Welcome to COZA STORE</h3>"
                        + "<div>This is your verify code: "+ v.getCode() + "</div>\n"
                        + "<div>Please <a href='http://localhost:8080/CozaStoreFashion/login' >Login</a> to use service. Thanks !</div\n"
                        + "</body>\n"
                        + "</html>";
                
                SendEmail sm = new SendEmail();
                boolean a = sm.sendMail(email, "COZA", message);
                alertMsg = "Register Success!";

                request.setAttribute("alert1", alertMsg);
                request.getRequestDispatcher(Constant.Path.LOGIN).forward(request, response);
            } else {
                alertMsg = "System error!";
                request.setAttribute("alert", alertMsg);
                request.getRequestDispatcher(Constant.Path.REGISTER).forward(request, response);
            }

        } else {
            alertMsg = "Wrong password confirm!";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher(Constant.Path.REGISTER).forward(request, response);
        }

    }
}
