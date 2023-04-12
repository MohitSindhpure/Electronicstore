package com.shruteekatech.electronicstore.repository;


import com.shruteekatech.electronicstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Long> {


    List<Category> findAByTitleContaining(String keyword);
}
