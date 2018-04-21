package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("*/**")
    @ResponseBody
    public String test(@RequestBody(required = false) String body, HttpServletRequest request) {

        return body;
    }

}
