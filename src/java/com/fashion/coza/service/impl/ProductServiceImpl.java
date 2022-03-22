/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fashion.coza.service.impl;

import com.fashion.coza.dao.ProductDAO;
import com.fashion.coza.dao.impl.ProductDAOImpl;
import com.fashion.coza.entity.Product;
import com.fashion.coza.service.ProductService;
import java.util.List;

/**
 *
 * @author tuan anh
 */
public class ProductServiceImpl implements ProductService {

    ProductDAO productDao = new ProductDAOImpl();

    @Override
    public void insert(Product product) {
        productDao.insert(product);

    }
//

    @Override
    public void edit(Product newProduct) {
        Product oldProduct = productDao.get(newProduct.getPid());
        System.out.println(newProduct + ": prd in serv product admin");
        oldProduct.setPid(newProduct.getPid());
        oldProduct.setPname(newProduct.getPname());
        oldProduct.setPprice(newProduct.getPprice());
        oldProduct.setPdiscount(newProduct.getPdiscount());
        oldProduct.setPisNew(newProduct.isPisNew());
        oldProduct.setCid(newProduct.getCid());
        oldProduct.setPdes(newProduct.getPdes());

//        if (newProduct.getPimg()!= null) {
//            // XOA ANH CU DI
//            String fileName = oldProduct.getImage();
//            final String dir = "F:\\upload";
//            File file = new File(dir + "/" + fileName);
//            if (file.exists()) {
//                file.delete();
//            }
        oldProduct.setPimg(newProduct.getPimg());
        System.out.println(oldProduct + ": prd in serv product admin");
//        }

        productDao.edit(oldProduct);

    }
//

    @Override
    public void delete(int id) {
        productDao.delete(id);

    }
//

    @Override
    public Product get(int pid) {
        return productDao.get(pid);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getAlls() {
        return productDao.getAlls();
    }

    @Override
    public List<Product> getRelate(int cid) {
        return productDao.getRelate(cid);
    }

    @Override
    public List<Product> seachByName(String productName) {
        return productDao.seachByName(productName);
    }
}
