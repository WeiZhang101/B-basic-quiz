package com.example.quiz1;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//@Transactional
@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

    void createUser(User user) {
        userRepository.save(user);
    }


}
