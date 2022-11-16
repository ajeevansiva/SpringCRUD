package com.example.springcrud.service;

import com.example.springcrud.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> saveProducts(List<Product> products);

    List<Product> getProducts();

    Product getProductById(int id);

    Product getProductByName(String name);

    Product updateProduct(Product product);

    void deleteProduct(int id);
}
