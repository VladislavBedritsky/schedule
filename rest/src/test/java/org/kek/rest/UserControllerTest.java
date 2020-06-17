package org.kek.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kek.backend.model.User;
import org.kek.backend.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.mockito.ArgumentMatchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:test-rest.xml"})
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    private MockMvc mockMvc;
    private User user;

    public UserControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.userController).build();
        user = new User();
        user.setId("123");
        user.setUsername("username");
        user.setPassword("password");
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesUserController() {
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(wac.getBean("userController"));
    }

    @Test
    public void givenUsersURI_whenMockMVC_thenVerifyResponse() throws Exception {

        this.mockMvc.perform(get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));

        Mockito.verify(userService, Mockito.times(1))
                .findAll();

    }

    @Test
    public void givenUserIdURI_whenMockMVC_thenVerifyResponse() throws Exception {
        Mockito.when(userService.findUserById("123")).thenReturn(user);

        this.mockMvc.perform(get("/users/123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password"));

        Mockito.verify(userService, Mockito.times(1))
                .findUserById(isA(String.class));

    }

    @Test
    public void should_CreateUser_When_ValidRequest() throws Exception {

        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()
        );

        Mockito.verify(userService, Mockito.times(1))
                .saveUser(isA(User.class));

    }

    @Test
    public void should_updateUserName_When_ValidRequest() throws Exception {
        Mockito.when(userService.findUserById("123")).thenReturn(user);

        this.mockMvc.perform(put("/users/123")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(user))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("username"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("password")
                );

        Mockito.verify(userService, Mockito.times(1))
                .updateUsername(isA(String.class), isA(User.class));

    }

    @Test
    public void should_deleteUser_When_ValidRequest() throws Exception {
        Mockito.when(userService.findUserById("123")).thenReturn(user);

        this.mockMvc.perform(delete("/users/123"))
                .andExpect(status().is(200));

        Mockito.verify(userService, Mockito.times(1))
                .removeUserById(isA(String.class));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}