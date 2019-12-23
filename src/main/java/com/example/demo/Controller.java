package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    Mydata mydata;
    @GetMapping("/api/1")
    public String getOne(){
        return Service2.get("1245710",Mydata.Cookie);
    }
    @GetMapping("/api/2")
    public String getTwo(){
        return Service2.get("1245841",Mydata.Cookie);
    }
    @GetMapping("/api/3")
    public String getThree(){
        return Service2.get("1245846",Mydata.Cookie);
    }
}
