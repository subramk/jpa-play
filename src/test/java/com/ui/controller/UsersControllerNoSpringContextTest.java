package com.ui.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jpa.play.persistence.model.User;
import com.service.layer.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class UsersControllerNoSpringContextTest {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UserService userService;

    @Before
    public  void  setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    //  Remove later once tests are sorted out...
    public void dummy(){
        Assert.assertTrue(true);
    }

    @Test
    public void testFindAllUsers() throws Exception  {
        List<User> userList = new ArrayList<User>();
        userList.add( new User());
        usersController.findAll();
        when(userService.findAll()).thenReturn(userList);
        verify(userService,times(1)).findAll();

    }

}