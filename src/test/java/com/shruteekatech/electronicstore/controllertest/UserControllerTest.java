package com.shruteekatech.electronicstore.controllertest;

import com.shruteekatech.electronicstore.controller.UserController;
import com.shruteekatech.electronicstore.dtos.UserDto;
import com.shruteekatech.electronicstore.model.User;
import com.shruteekatech.electronicstore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    User user,user1,user2;

    UserDto userDto;
    @BeforeEach
    public void init()
    {
        user= User.builder()
                .name("Isha")
                .about("Software Enginner")
                .email("isha@gmail.com").gender("Female")
                .imageName("abc.png").password("Isha@12234").build();
        user1= User.builder()
                .name("Ashu")
                .about("Software Enginner")
                .email("Ashu@gmil.com").gender("Female")
                .imageName("abc.png").password("1234@12").build();
        user2= User.builder()
                .name("Amruta")
                .about("Software Enginner")
                .email("Amruta@gmil.com").gender("Female")
                .imageName("abc.png").password("1234@12").build();
        userDto = UserDto.builder().about("My name").name("Isha Rathore")
                .imageName("xyz.png")
                .email("abc@gmail.com")
                .password("123@3isa").build();


    }

}
