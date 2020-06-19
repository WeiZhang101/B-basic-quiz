package com.example.quiz1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
@Service
public class UserService {
    public UserService() {
    }

    String sayHi() {
        return "hello world";
    }
}
