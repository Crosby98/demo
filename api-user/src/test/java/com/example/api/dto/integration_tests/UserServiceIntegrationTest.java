package com.example.api.dto.integration_tests;

import com.example.api.dto.UserDto;
import com.example.api.dto.dao.UserRepository;
import com.example.api.dto.withTestOauth2Authentication;
import com.example.api.web.bom.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class UserServiceIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository repository;

    @Test
    @withTestOauth2Authentication()
    public void shouldReturnUserByPhone() throws Exception {

        String phone = "0506856170";

        UserDto userDto = createUserDto();
        userDto.setPhone(phone);

        repository.save(userDto);

        MvcResult result = mockMvc.perform(get("/" + phone)
                .header("Authorization", "Bearer " + SecurityContextHolder.getContext().getAuthentication().getDetails())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        ObjectMapper jsonMapper = new ObjectMapper();

        User returnedUser = jsonMapper.readValue(result.getResponse().getContentAsString(), User.class);

        assertEquals(userDto.getPhone(), returnedUser.getPhone());
        assertEquals(userDto.getStatus(), returnedUser.getStatus());
        assertEquals(userDto.getFirstName(), returnedUser.getFirstName());
        assertEquals(userDto.getSurName(), returnedUser.getSurName());
        assertEquals(userDto.getEmail(), returnedUser.getEmail());
        assertNull(returnedUser.getPassword());
    }

    @Test
    public void shouldRegisterUser() throws Exception {
        UserDto userDto = createUserDto();
        userDto.setPhone("11111111");

        mockMvc.perform(post("/register")
                .content(createJsonFromObject(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        UserDto byPhone = repository.findByPhone("11111111");

        assertNotNull(byPhone);
    }
}
