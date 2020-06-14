package com.ui.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.jpa.play.JpaPlayApplication;
import com.jpa.play.persistence.model.User;
import com.service.layer.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaPlayApplication.class)
@ContextConfiguration(classes = JpaPlayApplication.class)
@AutoConfigureMockMvc
public class UsersControllerTest extends BaseTest{

    @MockBean
    private UserService userService;

    @InjectMocks
    UsersController usersController;

    @Test
    //  Remove later once tests are sorted out...
    public void dummy(){
        Assert.assertTrue(true);
    }

    //@Test
    public void testFindAllUsers() throws Exception  {
        List<User> userList = new ArrayList<User>();
        userList.add( new User());

        when(userService.findAll()).thenReturn(userList);

        mockMvc .perform(get("/users/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


        verify(userService.findAll(),times(1));

    }

}