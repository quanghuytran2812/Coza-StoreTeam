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
import com.fashion.coza.util.RandomUUID;
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
public class WellcomeController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<Product> productList = productService.getAlls();
        List<Category> cateList = cateService.getAll();
        
        request.setAttribute("pwelcome", productList);
        request.setAttribute("cwelcome", cateList);
        request.getRequestDispatcher("/view/client/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
    }
}
