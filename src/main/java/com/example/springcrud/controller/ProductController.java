package com.example.springcrud.controller;

import com.example.springcrud.entity.Product;
import com.example.springcrud.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("list")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("search")
    public Product findProductByName(@RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "") String address){
        return productService.getProductByName(name);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {return productService.updateProduct(product); }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
}
