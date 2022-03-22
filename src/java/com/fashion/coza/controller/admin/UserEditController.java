/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.controller.admin;

import com.fashion.coza.entity.User;
import com.fashion.coza.service.UserService;
import com.fashion.coza.service.impl.UserServiceImpl;
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
public class UserEditController extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        int uid = Integer.parseInt(request.getParameter("uid"));

        User user = userService.get(uid);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/view/admin/edituser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String id = "";
        String uname = "";
        String pass = "";
        String role = "";
        String email = "";

        User user = new User();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {

            List<FileItem> items = servletFileUpload.parseRequest(request);

            for (FileItem item : items) {

                if (item.getFieldName().equals("uid")) {
                    id = item.getString();
                    user.setUid(Integer.parseInt(id));
                } else if (item.getFieldName().equals("uemail")) {
                    email = item.getString();
                    user.setUemail(item.getString());
                } else if (item.getFieldName().equals("usname")) {
                    uname = item.getString();
                    user.setUsname(item.getString());
                } else if (item.getFieldName().equals("upassword")) {
                    pass = item.getString();
                    user.setUpassword(item.getString());
                } else if (item.getFieldName().equals("uavatar")) {

                    if (item.getSize() > 0) {

                        String originalFileName = item.getName();

                        int index = originalFileName.lastIndexOf(".");
                        String ext = originalFileName.substring(index + 1);
                        String fileName = System.currentTimeMillis() + "." + ext;

                        File file = new File(request.getRealPath("/") + "pics" + File.separator + fileName);
                        item.write(file);
                        user.setUavatar(fileName);
                    } else {
                        user.setUavatar(null);
                    }

                } else if (item.getFieldName().equals("urole")) {
                    role = item.getString();
                    boolean isRole = false;
                    if (role.equalsIgnoreCase("Admin")) {
                        isRole = true;
                    } else if (role.equalsIgnoreCase("User")) {
                        isRole = false;
                    }

                    user.setUrole(isRole);
                }

            }

            System.out.println(id + "|" + email + "|" + uname + "|" + pass + "|" + role + "|| do post admin edit user");

            userService.edit(user);
            response.sendRedirect(request.getContextPath() + "/admin/user/list");

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            response.sendRedirect(request.getContextPath() + "/admin/user/list");
        }

    }

}
