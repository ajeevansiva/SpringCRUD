package com.example.springcrud;

import com.example.springcrud.entity.Product;
import com.example.springcrud.repository.ProductRepository;
import com.example.springcrud.service.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcrudApplicationTests {

    @Autowired
    private ProductServiceImpl service;

    @MockBean
    private ProductRepository repository;

        @Test
            public void getProductsTest () {
                        when(repository.findAll()).thenReturn(Stream.of(new Product(1, "mobile", 0, 5000),
                    new Product(2, "ajee", 3, 546)).collect(Collectors.toList()));
            assertEquals(2, service.getProducts().size());
        }

        @Test
        public void getProductByIdTest () {
            service.getProductById(1);
            when(repository.findById(1)).thenReturn(Optional.of(new Product(1, "mobile", 0, 5000)));
            assertEquals(new Product(1, "mobile", 0, 5000), service.getProductById(1));

        }

        @Test
        public void addProductTest() {
            Product product = new Product(5, "mouse", 2, 5000);
            when(repository.save(product)).thenReturn(product);
            assertEquals(product, service.saveProduct(product));
        }

        @Test
        public void addProducts(){
            Product product = new Product()
        }

        @Test
        public void deleteUserTest() {
            service.deleteProduct(3);
            verify(repository, times(1)).deleteById(3);
        }
    }



