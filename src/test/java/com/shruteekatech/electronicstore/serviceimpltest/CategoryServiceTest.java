package com.shruteekatech.electronicstore.serviceimpltest;

import com.shruteekatech.electronicstore.BaseTest;
import com.shruteekatech.electronicstore.dtos.CategoryDto;
import com.shruteekatech.electronicstore.repository.CategoryRepo;
import com.shruteekatech.electronicstore.service.CategoryService;
import jdk.jfr.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

public class CategoryServiceTest extends BaseTest {

    @MockBean
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;


    Category category1, category2, category3;

    List<Category> categories;

    CategoryDto categoryDto;

}
