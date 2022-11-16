package com.example.springcrud.service;

import com.example.springcrud.entity.Product;
import com.example.springcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
      return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }
    public List<Product> getProducts(){
        List<Product> products = productRepository.findAll();
        System.out.println("Getting Data From DB : " + products);
        return products;
    }
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }
}
