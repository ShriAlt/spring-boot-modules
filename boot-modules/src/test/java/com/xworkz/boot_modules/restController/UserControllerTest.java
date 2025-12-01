package com.xworkz.boot_modules.restController;

import com.xworkz.boot_modules.dto.UserDto;
import com.xworkz.boot_modules.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService service;



    @Test
    void whenInvalidUser_thenReturnsBadRequest() throws Exception {
        String invalidUserJson = "{ \"name\": \"\" }";

        mockMvc.perform(post("/users")   // endpoint path
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(invalidUserJson))
                .andExpect(status().isBadRequest());  // Expect 400
    }

    @Test
    void whenValidUser_thenReturnsCreated() throws Exception {
        String validUserJson = "{\n" +
                "  \"updateId\": 0,\n" +
                "  \"name\": \"string\",\n" +
                "  \"email\": \"string\",\n" +
                "  \"phoneNumber\": \"6392371068\",\n" +
                "  \"addressDtos\": [\n" +
                "    {\n" +
                "      \"updateAddressId\": 0,\n" +
                "      \"street\": \"string\",\n" +
                "      \"city\": \"string\",\n" +
                "      \"state\": \"string\",\n" +
                "      \"postalCode\": \"324078\",\n" +
                "      \"country\": \"string\",\n" +
                "      \"landmark\": \"string\",\n" +
                "      \"addressType\": \"Office\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        when(service.saveAndValidate(any(UserDto.class))).thenReturn("saved");

        mockMvc.perform(post("/users")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(validUserJson))
                .andExpect(status().isCreated())  // Expect 201
                .andExpect((ResultMatcher) content().string("user saved"));  // Response body
    }
}