package com.shruteekatech.electronicstore.serviceimpltest;

import com.shruteekatech.electronicstore.dtos.UserDto;
import com.shruteekatech.electronicstore.model.User;
import com.shruteekatech.electronicstore.repository.UserRepository;
import com.shruteekatech.electronicstore.service.impl.UserServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ServiceTest {

    @MockBean
    private UserRepository repositroy;

    @MockBean
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceimpl userService;

    User user;
    @BeforeEach
    public void init()
    {
         user=User.builder()
                .id(1l)
                .name("mohit")
                .about("Software Enginner")
                .email("mohitsindhpure1998@gmail.com")
                .gender("Male")
                .imageName("abc.png")
                .password("1234@12")
                .build();
    }

    @Test
    public void createuserTest()
    {
        Mockito.when(repositroy.save(Mockito.any())).thenReturn(user);
        UserDto user1= userService.createUser(modelMapper.map(user,UserDto.class));

        System.out.println(user1.getName());
        Assertions.assertNotNull(user1);
        Assertions.assertEquals(user1,user);
    }

}
