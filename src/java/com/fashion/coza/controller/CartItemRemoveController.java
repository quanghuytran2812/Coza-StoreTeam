/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller;

import com.fashion.coza.entity.CartItem;
import java.io.IOException;
import java.util.Map;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tuan anh
 */
public class CartItemRemoveController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession httpSession = request.getSession();
        
        Object obj = httpSession.getAttribute("cart");// Doc tu Session ra
        
        String pid = request.getParameter("pid");
        
        if (obj != null) {
            
            @SuppressWarnings("unchecked")
            Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj; // ep ve kieu cua no
            // Xoa san pham trong map
            map.remove(Integer.parseInt(pid));

            // Cap nhat lai Session
            httpSession.setAttribute("cart", map);
        }

        response.sendRedirect(request.getContextPath() + "/member/cart");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

    }
}
