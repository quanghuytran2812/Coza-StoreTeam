/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller;

import com.fashion.coza.entity.CartItem;
import com.fashion.coza.entity.Product;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fashion.coza.service.ProductService;
import com.fashion.coza.service.impl.ProductServiceImpl;
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
@SuppressWarnings("serial")
public class CartAddController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String pid = request.getParameter("pid");
        String quantity = request.getParameter("quantity");

        Product product = productService.get(Integer.parseInt(pid));

        CartItem cartItem = new CartItem();
        cartItem.setIquantity(Integer.parseInt(quantity));
        cartItem.setIunitPrice(product.getPprice());
        cartItem.setProduct(product);

        HttpSession httpSession = request.getSession();
        Object obj = httpSession.getAttribute("cart");
//        System.out.println(obj);

        if (obj == null) {
            
            Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
            map.put(cartItem.getProduct().getPid(), cartItem);
            httpSession.setAttribute("cart", map);
//            System.out.println(map);

        } else {

            Map<Integer, CartItem> map = extracted(obj);
            CartItem existedCartItem = map.get(Integer.valueOf(pid));
//            System.out.println(map.size());

            if (existedCartItem == null) {

                map.put(product.getPid(), cartItem);
//                System.out.println(map);

            } else {

                existedCartItem.setIquantity(existedCartItem.getIquantity() + Integer.parseInt(quantity));
//                System.out.println(existedCartItem);

            }

            httpSession.setAttribute("cart", map);
//            System.out.println(map);

        }
        response.sendRedirect(request.getContextPath() + "/product/list");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

    }

    @SuppressWarnings("unchecked")
    private Map<Integer, CartItem> extracted(Object obj) {
        return (Map<Integer, CartItem>) obj;
    }

}
