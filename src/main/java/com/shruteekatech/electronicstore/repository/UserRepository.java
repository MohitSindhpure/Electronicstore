package com.shruteekatech.electronicstore.repository;


import com.shruteekatech.electronicstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findByEmail(String email);
   Optional<User> findByEmailAndPassword(String email,String password);
   List<User> findByNameContaining(String keyword);
}
