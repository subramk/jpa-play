package com.jpa.play.ui.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jpa.play.persistence.model.Users;
import com.jpa.play.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class UsersControllerNoSpringContextTests {

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
        List<Users> usersList = new ArrayList<Users>();
        usersList.add( new Users());
        when(userService.findAll()).thenReturn(usersList);
        usersController.findAll();
        verify(userService,times(1)).findAll();

    }

}