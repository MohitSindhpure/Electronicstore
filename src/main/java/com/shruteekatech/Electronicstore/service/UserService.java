package com.shruteekatech.ecommerce.service;


import com.shruteekatech.ecommerce.dtos.PagableResponse;
import com.shruteekatech.ecommerce.dtos.UserDto;
import net.sf.jasperreports.engine.JRException;


import java.io.FileNotFoundException;
import java.util.List;

public interface UserService {


//    create Userser
    UserDto createUser(UserDto user);

//    update User

    UserDto updateUser(UserDto user,Long userid);

//    delete User
    void deleteUser(Long userid);

//    getall User

    PagableResponse getAllUsers(Integer pagenumber, Integer pagesize, String sortBy, String sortDir);

//    getsingle User

    UserDto getSingleUser(Long userid);
//    get user by email
    UserDto getUserbyEmail(String email);
//    search user

    List<UserDto> searchUsers(String keyword);
//    other specific user
  String exportrept(String reportformat) throws FileNotFoundException, JRException;
}
