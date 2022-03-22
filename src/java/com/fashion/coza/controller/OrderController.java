/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller;

import com.fashion.coza.entity.Cart;
import com.fashion.coza.entity.CartItem;
import com.fashion.coza.entity.User;
import com.fashion.coza.service.CartItemService;
import com.fashion.coza.service.CartService;
import com.fashion.coza.service.UserService;
import com.fashion.coza.service.impl.CartItemServiceImpl;
import com.fashion.coza.service.impl.CartServiceImpl;
import com.fashion.coza.service.impl.UserServiceImpl;
import com.fashion.coza.tools.SendEmail;
import com.fashion.coza.util.RandomUUID;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tuan anh
 */
public class OrderController extends HttpServlet {

    UserService userService = new UserServiceImpl();
    CartService cartService = new CartServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();

    long time = System.currentTimeMillis();

    @SuppressWarnings("static-access")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Object obj = session.getAttribute("account");
        User buyer = (User) obj;

        Cart cart = new Cart();

        cart.setUser(buyer);
        cart.setKbuyDate(new java.sql.Date(time));
        cart.setKid(RandomUUID.getRandomID());

        cartService.insert(cart);

        Object objCart = session.getAttribute("cart");

        if (objCart != null) {
            // ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
            @SuppressWarnings("unchecked")
            Map<Integer, CartItem> map = (Map<Integer, CartItem>) objCart;

            for (CartItem cartItem : map.values()) {

                cartItem.setCart(cart);
                cartItem.setIid(RandomUUID.getRandomID());
                
                SendEmail sm = new SendEmail();
                sm.sendMail(cart.getUser().getUemail(), "COZA STORE", " Hi! Your order is being confirmed! Welcome to the <a href='http://localhost:8080/CozaStoreFashion/' >COZA</a> family! Thanks. ");
                cartItemService.insert(cartItem);
                
                

            }
            session.removeAttribute("cart");
            response.sendRedirect(request.getContextPath() + "/waiting");

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

    }
}
