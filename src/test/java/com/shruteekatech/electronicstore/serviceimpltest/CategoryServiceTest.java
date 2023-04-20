package com.shruteekatech.electronicstore.serviceimpltest;

import com.shruteekatech.electronicstore.BaseTest;
import com.shruteekatech.electronicstore.repository.CategoryRepo;
import com.shruteekatech.electronicstore.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class CategoryServiceTest extends BaseTest {

    @MockBean
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;
}
