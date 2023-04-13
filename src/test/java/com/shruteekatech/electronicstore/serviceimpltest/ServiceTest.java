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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class ServiceTest {

    @MockBean
    private UserRepository repositroy;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceimpl userService;

    User user;
    @BeforeEach
    public void init()
    {
         user=User.builder()

                .name("mohit")
                .about("Software Enginner")
                .email("mohitsindhpure1998@gmail.com")
                .gender("Male")
                .imageName("abc.png")
                .password("1234@12")
                .build();
    }

    // create User

    @Test
    public void createuserTest()
    {
        Mockito.when(repositroy.save(Mockito.any())).thenReturn(user);
        UserDto user1= userService.createUser(modelMapper.map(user,UserDto.class));

        System.out.println(user1.getName());
        Assertions.assertEquals(user.getName(),user1.getName());
        Assertions.assertNotNull(user1);

    }

    // Update User Test
    @Test
    public void updateUserTest(){
        Long id=1l;

        UserDto userDto = UserDto.builder()
                .name("Mohit Sindhpure")
                .email("mohit@123")
                .password("Mohit@123")
                .gender("Male")
                .about("this is update my name.")
                .imageName("abc.png").build();

        Mockito.when(repositroy.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Mockito.when(repositroy.save(Mockito.any())).thenReturn(user);

        UserDto updateUser = userService.updateUser(userDto, id);
        System.out.println(updateUser.getName());
        Assertions.assertNotNull(userDto);
        Assertions.assertEquals(userDto.getName(),updateUser.getName(),"name is valid");


    }


}
