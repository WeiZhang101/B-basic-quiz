package com.example.quiz1;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Service
public class EducationService {
    final EducationRepository educationRepository;
    final UserService userService;

    public EducationService(EducationRepository educationRepository, UserService userService){
        this.educationRepository = educationRepository;
        this.userService = userService;
    }

    public List<Education> getEducationById(long id){
        return educationRepository.findAllByUser(userService.getUserById(id));
    }

    public void createEducation(long userid, Education educationAdd){
//        educationAdd.setUserId(userid);
//        educationAdd.setUser(userService.getUserById(userid));
        educationAdd.setUser(userService.getUserById(userid));
        educationRepository.save(educationAdd);
    }

}
