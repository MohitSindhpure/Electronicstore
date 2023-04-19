package com.shruteekatech.electronicstore.serviceimpltest;

import com.shruteekatech.electronicstore.dtos.ProductDto;
import com.shruteekatech.electronicstore.model.Product;
import com.shruteekatech.electronicstore.repository.ProductRepo;
import com.shruteekatech.electronicstore.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

public class ProductServiceTest {

    @MockBean
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    Product product1,product2,product3;

    List<Product> products;

    ProductDto productDto;
}
