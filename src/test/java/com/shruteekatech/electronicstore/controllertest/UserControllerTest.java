package com.shruteekatech.electronicstore.controllertest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shruteekatech.electronicstore.BaseTest;
import com.shruteekatech.electronicstore.controller.UserController;
import com.shruteekatech.electronicstore.dtos.UserDto;
import com.shruteekatech.electronicstore.model.User;
import com.shruteekatech.electronicstore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class UserControllerTest extends BaseTest {

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
                .name("Mohit")
                .about("Software Enginner")
                .email("Mohit@gmail.com").gender("Male")
                .imageName("abc.png").password("Mohit@12234").build();
        user1= User.builder()
                .name("Rohan")
                .about("Software Enginner")
                .email("Rohan@gmil.com").gender("male")
                .imageName("abc.png").password("1234@12").build();
        user2= User.builder()
                .name("Shubham")
                .about("Software Enginner")
                .email("Shubham@gmil.com").gender("male")
                .imageName("abc.png").password("1234@12").build();
        userDto = UserDto.builder().about("My name").name("Mohit Sindhpure")
                .imageName("xyz.png")
                .email("abc@gmail.com")
                .password("123@3mohit").build();

    }

    @Test
    public void createUserTest() throws Exception {


        UserDto dto = modelMapper.map(user, UserDto.class);
        Mockito.when(userService.createUser(Mockito.any())).thenReturn(dto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/Api/Users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(converobjectTojsonString(user))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.email").exists());


    }

    private String converobjectTojsonString(User user) {
        try
        {
            return new ObjectMapper().writeValueAsString(user);
        } catch (RuntimeException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
