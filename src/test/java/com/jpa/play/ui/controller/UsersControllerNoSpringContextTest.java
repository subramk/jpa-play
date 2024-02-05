package com.jpa.play.ui.controller;

import com.jpa.play.persistence.model.Users;
import com.jpa.play.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class UsersControllerNoSpringContextTest {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UserService userService;

    @BeforeEach
    public  void  setUp() {
        MockitoAnnotations.initMocks(this);
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