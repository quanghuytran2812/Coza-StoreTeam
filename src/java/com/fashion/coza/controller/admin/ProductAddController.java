/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller.admin;

import com.fashion.coza.entity.Category;
import com.fashion.coza.entity.Product;
import com.fashion.coza.service.CategoryService;
import com.fashion.coza.service.ProductService;
import com.fashion.coza.service.impl.CategoryServiceImpl;
import com.fashion.coza.service.impl.ProductServiceImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author tuan anh
 */
@SuppressWarnings("serial")
@MultipartConfig
public class ProductAddController extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/view/admin/addproduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Product product = new Product();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        String name = "";
        int cid = 0;
        double price = 0;
        int discount = 0;
        String description = "";
        boolean isnew = false;
        String img = "";
        
        try {
            List<FileItem> items = servletFileUpload.parseRequest(request);
            for (FileItem item : items) {
                if (item.getFieldName().equals("pname")) {
                    name = item.getString();
                    product.setPname(item.getString());
                } else if (item.getFieldName().equals("cid")) {
                    cid = Integer.parseInt(item.getString());
                    product.setCid(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("pprice")) {
                    price = Double.parseDouble(item.getString());
                    product.setPprice(Double.parseDouble(item.getString()));
                } else if (item.getFieldName().equals("pdiscount")) {
                    discount = Integer.parseInt(item.getString());
                    product.setPdiscount(Integer.parseInt(item.getString()));
                } else if (item.getFieldName().equals("pdes")) {
                    description = item.getString();
                    product.setPdes(item.getString());
                } else if (item.getFieldName().equals("pisNew")) {
                    isnew = Boolean.parseBoolean(item.getString());
                    product.setPisNew(Boolean.parseBoolean(item.getString()));;
                } else if (item.getFieldName().equals("pimg")) {

                    String originalFileName = item.getName();

                    int index = originalFileName.lastIndexOf(".");
                    String ext = originalFileName.substring(index + 1);
                    String fileName = System.currentTimeMillis() + "." + ext;

                    File file = new File(request.getRealPath("/") + "pics" + File.separator + fileName);
                    item.write(file);
                    img = fileName;
                    product.setPimg(fileName);
                } else {
                    product.setPimg(null);
                }
            }
            System.out.println(name + " | " + cid + " | " + price + " | " + discount + " | " + description + " | " + isnew + " | " + img + ": Controller admin add product");
            productService.insert(product);
            response.sendRedirect(request.getContextPath() + "/admin/product/list");
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
