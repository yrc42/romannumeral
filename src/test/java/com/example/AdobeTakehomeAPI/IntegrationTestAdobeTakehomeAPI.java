package com.example.AdobeTakehomeAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTestAdobeTakehomeAPI {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRomanToIntegerEndpoint_ValidInput_ReturnsInteger() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/romannumeral")
                        .param("query", "3999"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value(3999))
                .andExpect(MockMvcResultMatchers.jsonPath("$.output").value("MMMCMXCIX"));
    }

    @Test
    public void testRomanToIntegerEndpoint_InvalidInput_ReturnsBadRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/romannumeral")
                        .param("query", "4000"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}