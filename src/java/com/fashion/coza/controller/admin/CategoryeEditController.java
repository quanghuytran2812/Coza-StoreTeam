/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller.admin;

import com.fashion.coza.entity.Category;
import com.fashion.coza.service.CategoryService;
import com.fashion.coza.service.impl.CategoryServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tuan anh
 */
@SuppressWarnings("serial")
public class CategoryeEditController extends HttpServlet {

    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        int cid = Integer.parseInt(request.getParameter("cid"));
        Category category = cateService.get(cid);
        request.setAttribute("category", category);
        request.getRequestDispatcher("/view/admin/editcate.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Category category = new Category();
        category.setCid(Integer.parseInt(request.getParameter("cid")));
        category.setCname(request.getParameter("cname"));
        category.setCsession(request.getParameter("csession"));
        category.setCimg("defaul.png");
        cateService.edit(category);
        
        response.sendRedirect(request.getContextPath() + "/admin/category/list");

    }
}
