package com.craftgirlsss.api.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.craftgirlsss.api.entity.User;
import com.craftgirlsss.api.models.RegisterUserRequest;
import com.craftgirlsss.api.models.WebResponse;
import com.craftgirlsss.api.repository.UserRepository;
import com.craftgirlsss.api.security.BCrypt;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        userRepository.deleteAll();
    }

    @Test
    void testRegisterSuccess() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("Saputra");
        request.setPassword("KaliLinux");
        request.setName("Test");
        mockMvc.perform(post("/api/users").accept(org.springframework.http.MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpectAll(status().isOk()).andDo(result -> {

          WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});

          assertEquals("OK", response.getData());
        });
    }

    @Test
    void testRegisterBadRequest() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("");
        request.setPassword("");
        request.setName("");
        mockMvc.perform(post("/api/users").accept(org.springframework.http.MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpectAll(status().isBadRequest()).andDo(result -> {

          WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});

          assertNotNull(response.getError());
        });
    }

    @Test
    void testRegisterDuplicate() throws Exception {

        User user = new User();
        user.setUsername("putra");
        user.setPassword(BCrypt.hashpw("KaliLinux23/", BCrypt.gensalt()));
        user.setName("Putra");
        userRepository.save(user);

        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("putra");
        request.setPassword("KaliLinux23/");
        request.setName("Putra");
        mockMvc.perform(post("/api/users").accept(org.springframework.http.MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpectAll(status().isBadRequest()).andDo(result -> {

          WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>(){});

          assertNotNull(response.getError());
        });
    }
}
