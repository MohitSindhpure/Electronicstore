package com.shruteekatech.electronicstore.serviceimpltest;

import com.shruteekatech.electronicstore.BaseTest;
import com.shruteekatech.electronicstore.dtos.ProductDto;
import com.shruteekatech.electronicstore.model.Product;
import com.shruteekatech.electronicstore.repository.ProductRepo;
import com.shruteekatech.electronicstore.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest extends BaseTest {

    @MockBean
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    Product product1,product2,product3;

    List<Product> products;

    ProductDto productDto;

    @BeforeEach
    public void init()
    {
        product1=Product.builder()
                .brand("Fair Handsome")
                .title("Cosmetics")
                .price(8000.0).live(true).stock(true)
                .description("All cosmetics are available")
                .quantity(9).discount("10%").build();
        product2=Product.builder()
                .brand("Lakme")
                .title("Cosmetics")
                .price(1000.0).live(true).stock(true)
                .description("All cosmetics are available")
                .quantity(10).discount("20%").build();
        product3=Product.builder()
                .brand("Borolin")
                .title("Cometics")
                .price(9000.0).live(true).stock(true)
                .description("All cosmetics are available")
                .quantity(10).discount("20%").build();

        productDto= ProductDto.builder()
                .brand("Pandrom +")
                .title("Cometics")
                .price(1000.0).live(true).stock(true)
                .description("All cosmetics are avilable")
                .quantity(10).discount("20%").build();

        products=new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

    }

    @Test
    public void createProductTest()
    {
        Mockito.when(productRepo.save(Mockito.any())).thenReturn(product1);

        ProductDto product = productService.createProduct(modelMapper.map(product1, ProductDto.class));
        Assertions.assertNotNull(product);
        Assertions.assertEquals(product1.getBrand(),product.getBrand());
    }

    @Test
    public void updateProducts()
    {
        Long id=1l;
        Mockito.when(productRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(product1));
        Mockito.when(productRepo.save(Mockito.any())).thenReturn(product1);
        ProductDto productDtos = productService.updateProducts(productDto, id);

        Assertions.assertNotNull(productDtos);
        Assertions.assertEquals(product1.getBrand(),productDtos.getBrand());

    }
    @Test
    public void deleteProductTest()
    {
        Long id=10l;
        Mockito.when(productRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(product1));

        productService.deleteProduct(id);
        Mockito.verify(productRepo,Mockito.times(1)).delete(product1);

    }
    @Test
    public void getByIdTest()
    {
        Long id=10l;
        Mockito.when(productRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(product1));

        ProductDto productbyid = productService.getById(id);

        Assertions.assertEquals(product1.getPid(),productbyid.getPid());

    }



}
