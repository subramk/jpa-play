package com.jpa.play.ui.controller;

import com.jpa.play.persistence.model.Users;
import com.jpa.play.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Mention the controllers , instead of all the controllers being loaded by default as part of the WebMvcTest SpringWeb Context.
@WebMvcTest(UsersController.class)
@Disabled
class UsersControllerTest {

    // This Places the Mocked Spring bean in the SLICED WEBMVC CONTEXT  sliced WebMVC is a lightweight Servlet context used in
    // web tier tests on the Spring Framework.
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    //@MockBean
    // HAVING the Controller Wired Here as a @MockBean overrides the mockMVC from interacting with a MOCK Controller when tests are Run - consequently
    // failing all Tests . YOU HAVE BEEN WARNED !!!
    // private UsersController controller;

    @Test
    @Disabled
    public void checkIfAllArePopulated() {
        Assertions.assertNotNull(mockMvc);
        Assertions.assertNotNull(userService);
    //    Assertions.assertNotNull(webApplicationContext);
    }
    @Test
    public void testFindAllUsers() throws Exception {
        List<Users> usersList = new ArrayList<>();
        Users user1 = new Users();
        user1.setId(1L);
        user1.setName("Rakesh");
        usersList.add(user1);

        // NO ACTUAL CALL TO CONTROLLER IS REQUIRED.
        //ResponseEntity<Users> usersResponseEntity   = userController.findAll(anyString());
        // this mockMvc acts as a controller for our Testing purposes
        mockMvc.perform(get("/users/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        when(userService.findAll()).thenReturn(usersList);
        verify(userService, times(1)).findAll();

    }

    @Test
    public void testFindByName() throws Exception {
        Users user1 = new Users();
        user1.setId(1L);
        user1.setName("Rakesh");

        mockMvc.perform(get("/users/findByName")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // mock when
        when(userService.findByName(anyString())).thenReturn(user1);
        // NO ACTUAL CALL TO CONTROLLER IS REQUIRED.
        //ResponseEntity<Users> usersResponseEntity   = userController.findByName(anyString());
        // this mockMvc acts as a controller for our Testing purposes

        // verify step
        verify(userService, times(1)).findByName(anyString());
    }
}
