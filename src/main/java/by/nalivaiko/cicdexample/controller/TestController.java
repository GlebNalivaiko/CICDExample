package by.nalivaiko.cicdexample.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//если ты его не добавил в гит то при комите он даже не предложит добавить его
@RestController
public class TestController {

    @GetMapping("test")
    public String getHello() {
        return "hello world!";
    }
}
