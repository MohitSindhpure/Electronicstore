package com.shruteekatech.electronicstore.service;


import com.shruteekatech.electronicstore.dtos.PagableResponse;
import com.shruteekatech.electronicstore.dtos.ProductDto;

public interface ProductService {

//    create

    ProductDto createProduct(ProductDto productDto);
//    Update
    ProductDto updateProducts(ProductDto productDto,Long productid);

//    getByid
    ProductDto getById(Long productID);

//    Delete

    void deleteProduct(Long productId);
//    getall

    PagableResponse<ProductDto> getAllProducts(Integer pagesize, Integer pagenumber, String sortBy, String sortDir);
//    Getbytitle
    PagableResponse<ProductDto> searchByTitle(String title,Integer pagesize,Integer pagenumber,String sortBy,String sortDir);
//    getbyLive
    PagableResponse<ProductDto> searchByLive(Boolean live,Integer pagesize,Integer pagenumber,String sortBy,String sortDir);


}
