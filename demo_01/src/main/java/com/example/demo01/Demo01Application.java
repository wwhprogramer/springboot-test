package com.example.demo01;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@RestController
@MapperScan("com.example.demo01.mapper")
@SpringBootApplication
public class Demo01Application {


    public static void main(String[] args) {
        SpringApplication.run(Demo01Application.class, args);
    }

//    @RequestMapping(value = "/src", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET)
//    public String index() {
//        HashMap map = new HashMap();
//        map.put("a", "aaa");
//        map.put("user", new User("b", 13));
//        return JSON.toJSONString(map);
//    }

}


