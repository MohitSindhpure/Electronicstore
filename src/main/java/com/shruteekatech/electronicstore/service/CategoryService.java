package com.shruteekatech.electronicstore.service;



import com.shruteekatech.electronicstore.dtos.CategoryDto;
import com.shruteekatech.electronicstore.dtos.PagableResponse;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface CategoryService {

//    Create
    CategoryDto createCategory(CategoryDto categoryDto);

//    Update
    CategoryDto updateCategory(CategoryDto Category,Long catId);

//    GetSinglecategory
    CategoryDto getSingleCategory(Long catID);

//    GetAll Category
    PagableResponse<CategoryDto> getAllcategories(Integer pagenumber, Integer pagesize, String sortBy, String sortDir);

//    Search Category
    List<CategoryDto> searchCategory(String keyword);

//    Delete Category
    void deleteCategory(Long catid);

    String exportrept(String reportformat) throws FileNotFoundException, JRException;
}
