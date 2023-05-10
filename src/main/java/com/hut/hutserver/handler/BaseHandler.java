package com.hut.hutserver.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public abstract class BaseHandler {
    public void method() {
        System.out.println("hello method");
    }
}
