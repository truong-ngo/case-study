package com.example.shop_md3.service.impl;

import com.example.shop_md3.model.Product;
import com.example.shop_md3.service.IProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProductService implements IProductService {
    @Override
    public boolean create(HttpServletRequest request) {
        return false;
    }

    @Override
    public void render(HttpServletRequest request, List<Product> lists) {

    }

    @Override
    public void update(HttpServletRequest request) {

    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public Product getObject(HttpServletRequest request) {
        return null;
    }
}
