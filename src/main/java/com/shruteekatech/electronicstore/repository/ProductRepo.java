package com.shruteekatech.electronicstore.repository;


import com.shruteekatech.electronicstore.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {


    Page<Product> findAllByTitleContaining(String title,Pageable pageable);

    Page<Product> findAllByLiveTrue(Pageable pageable);
}
