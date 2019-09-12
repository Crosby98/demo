package com.example.api.dto.integration_tests;

import com.example.api.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application.properties")
abstract class BaseIntegrationTest {

    protected UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setPhone("000-000-000");
        userDto.setStatus("Active");
        userDto.setSurName("adada");
        userDto.setFirstName("fsfgfgdfgd");
        userDto.setEmail("dada@adada.com");
        userDto.setPassword("1234");
        return userDto;
    }

    protected String createJsonFromObject(Object source) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();
        String result;
        try {
            result = objectWriter.writeValueAsString(source);
            if (source instanceof String) {
                result = result.replace("\"", StringUtils.EMPTY);
            }
        } catch (JsonProcessingException e) {
            result = null;
        }
        return result;
    }
}
