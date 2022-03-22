/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller;

import com.fashion.coza.entity.Category;
import com.fashion.coza.entity.Product;
import com.fashion.coza.service.CategoryService;
import com.fashion.coza.service.ProductService;
import com.fashion.coza.service.impl.CategoryServiceImpl;
import com.fashion.coza.service.impl.ProductServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuan anh
 */
@SuppressWarnings("serial")
public class ProductSeachByName extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("search");
        List<Product> productSeachByName = productService.seachByName(name);
        List<Category> cateList = cateService.getAll();
        
        request.setAttribute("productSeachByName", productSeachByName);
        request.setAttribute("cateList", cateList);
        
        System.out.println(productSeachByName);
        request.getRequestDispatcher("/view/client/product-seach-by-name.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
    }
}
