package by.nalivaiko.cicdexample.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(TestController.class)//add because we test controller//add this annotation from main test
//@RequiredArgsConstructor
class TestControllerTest {


    @Autowired//without it doesn't work
    private MockMvc mockMvc;//we can mock our rest endpoints with this annotation,

    //here we have integration test because we have have a lot of another classes that weren't mocked,

    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test"))//We say that we want to test our methods, from path "/test"
                .andDo(MockMvcResultHandlers.print())//we did it to see some information in console//it is some kind of log;
                .andExpect(MockMvcResultMatchers.status().isOk())//we wait for a good request status
                .andExpect(MockMvcResultMatchers.content().string("hello world!"));//here we check our string from method, we also have opportunity to testing our Json method, which contains in content
    }
}