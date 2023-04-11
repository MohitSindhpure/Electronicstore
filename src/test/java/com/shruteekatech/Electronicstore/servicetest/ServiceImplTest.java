package com.shruteekatech.ecommerce.servicetest;

import com.shruteekatech.ecommerce.dtos.UserDto;
import com.shruteekatech.ecommerce.model.User;
import com.shruteekatech.ecommerce.repository.UserRepository;
import com.shruteekatech.ecommerce.service.UserService;
import com.shruteekatech.ecommerce.service.impl.UserServiceimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


public class ServiceImplTest {

    @MockBean
    private UserRepository repository;

    @MockBean
    private ModelMapper modelMapper;
    @InjectMocks
    private UserServiceimpl userService;

    User user;
    @BeforeEach
    public void init()
    {
       User user= User.builder()
               .id(1l)
                .name("Isha")
                .about("Software Enginner")
                .email("isha@gmil.com").gender("Female")
                .imageName("abc.png").password("1234@12").build();
    }

    @Test
    public void createuserTest()
    {
        Mockito.when(repository.save(Mockito.any())).thenReturn(user);
        UserDto user1 = userService.createUser(modelMapper.map(user, UserDto.class));
        System.out.println(user1.getName());
        Assertions.assertNotNull(user1);
        Assertions.assertEquals(user1,user);
    }


}
