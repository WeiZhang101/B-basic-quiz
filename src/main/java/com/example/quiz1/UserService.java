package com.example.quiz1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Scope(SCOPE_PROTOTYPE)
@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User(1, "Bob123", 24, "https://inews", "Lorem ipsum dolor sit amet"));
        userMap.put(2, new User(2, "KAMIL", 18, "https://inews.gtimg.com/newsapp_match/0/3581582328/0",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. "));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    String sayHi() {
        return "hello world";
    }

    public User getUserById(long id){
        for(User user: userMap.values()){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void createUser(User user) {
        user.setId(userMap.size() + 1);
        userMap.put((int) user.getId(), user);
    }

    public Boolean checkExistId(long id){
        if(id > userMap.size()){
            return false;
        }
        return true;
    }
}
