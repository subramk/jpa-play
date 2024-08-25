package com.jpa.play.ui.controller;

import com.jpa.play.persistence.model.Users;
import com.jpa.play.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.OverrideAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Mention the Individual  Controller , instead of all the Controllers being loaded by default as part of the WebMvcTest
// Context.
// @SpringBootTest is more for a full container load Integration Test
// @WebMvcTest is a 'Sliced' test - as it is only testing the Web Slice  - hence lighter and faster.


@WebMvcTest(UsersController.class)
@OverrideAutoConfiguration(enabled = false)
class UsersControllerTest {

    // This Places the Mocked Spring bean in the SLICED WEBMVC CONTEXT  -  Sliced WebMVC is a lightweight Servlet context used in
    // WebTier only.

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    public void beforeEachTest(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();

    }
    //@MockBean
    // HAVING the Controller Wired Here as a @MockBean overrides the mockMVC from interacting with a MOCK Controller when tests are Run - consequently
    // failing all Tests . YOU HAVE BEEN WARNED !!!
    // No Need to mock the Controller here.
    // private UsersController controller;

    @Test
    public void checkIfAllArePopulated() {
         assertNotNull(mockMvc);
         assertNotNull(userService);
         assertNotNull(webApplicationContext);
    }

    @Test
    public void testFindAllUsers() throws Exception {

        // NO ACTUAL CALL TO CONTROLLER IS REQUIRED.
        //ResponseEntity<Users> usersResponseEntity   = userController.findAll(anyString());
        // this mockMvc acts as a controller for our Testing purposes

        when(userService.findAll()).thenReturn(List.of((Users.builder().id(1L).name("kasi").build())));

        // mockMvc starts a lightweight servletContainer for us and hits the REAL  controller when this line is called.
        mockMvc.perform(get("/users/findAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

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
        //when(userService.findByName(anyString())).thenReturn(user1);
        // NO ACTUAL CALL TO CONTROLLER IS REQUIRED. This is done for us by the mockMVC
        //ResponseEntity<Users> usersResponseEntity   = userController.findByName(anyString());
        // this mockMvc acts as a controller for our Testing purposes

        // verify step
        verify(userService, times(1)).findByName(anyString());
    }
}
