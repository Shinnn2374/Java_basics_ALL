package com.skillbox.fibonacci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private FibonacciService service;

    @InjectMocks
    private FibonacciController controller;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testOne() throws Exception{
        mockMvc.perform(get("/fibonacci/1")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testTwo() throws Exception{
        mockMvc.perform(get("/fibonacci/0")).andExpect(status().is4xxClientError());
    }
}
