package com.shruteekatech.electronicstore.serviceimpltest;

import com.shruteekatech.electronicstore.dtos.PagableResponse;
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
import org.springframework.data.domain.*;

import java.util.Arrays;
import java.util.List;
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
        Assertions.assertEquals(userDto.getName(),updateUser.getName(),"name not valid");

    }

    @Test
    public void deleteuserTest(){
        Long id=1l;

        Mockito.when(repositroy.findById(id)).thenReturn(Optional.of(user));

        userService.deleteUser(id);

        Mockito.verify(repositroy,Mockito.times(1)).delete(user);

    }

    @Test
    public void getAllUsersTest(){

       User user1=User.builder()

                .name("tinku")
                .about("Mechanical Enginner")
                .email("tinku@gmail.com")
                .gender("Male")
                .imageName("ab.png")
                .password("1254@12")
                .build();

       User user2=User.builder()

                .name("tanay")
                .about("electrical Enginner")
                .email("tanay@gmail.com")
                .gender("Male")
                .imageName("ac.png")
                .password("1236@12")
                .build();


        List<User> userList = Arrays.asList(user,user1,user2);

        Page<User> page=new PageImpl<>(userList);

       Mockito.when(repositroy.findAll((Pageable) Mockito.any())).thenReturn(page);


        PagableResponse<UserDto> allUsers = userService.getAllUsers(1, 2, "name", "ascending");

        Assertions.assertEquals(3,allUsers.getContent().size());

    }

    @Test
    public void getUserByIdTest(){

        Long id=1l;

        Mockito.when(repositroy.findById(id)).thenReturn(Optional.of(user));
        UserDto singleUser = userService.getSingleUser(id);

        Assertions.assertNotNull(singleUser);
        Assertions.assertEquals(user.getName(),singleUser.getName(),"user id not matched.");
    }

    @Test
    public void getUserByEmailTest(){
        String emailId = "mohit@gmail.com";

        Mockito.when(repositroy.findByEmail(emailId)).thenReturn(Optional.of(user));

        UserDto email = userService.getUserbyEmail(emailId);

        Assertions.assertNotNull(email);
        Assertions.assertEquals(user.getEmail(),email.getEmail(),"Email Not Matched");
    }

    @Test
    public void serchUserTest(){

        User user1=User.builder()

                .name("tinku")
                .about("Mechanical Enginner")
                .email("tinku@gmail.com")
                .gender("Male")
                .imageName("ab.png")
                .password("1254@12")
                .build();

        User user2=User.builder()

                .name("tanay")
                .about("electrical Enginner")
                .email("tanay@gmail.com")
                .gender("Male")
                .imageName("ac.png")
                .password("1236@12")
                .build();

        User user3=User.builder()

                .name("Mohit")
                .about("Software Enginner")
                .email("mohit@gmail.com")
                .gender("Male")
                .imageName("mmm.png")
                .password("1239@12")
                .build();

        String keyword="mohit";

        Mockito.when(repositroy.findByNameContaining(keyword)).thenReturn(Arrays.asList(user,user1,user2,user3));

        List<UserDto> userDtos = userService.searchUsers(keyword);

        Assertions.assertEquals(4,userDtos.size(),"Size not Matched");
    }
}
