package com.example.quiz1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:1234")
@RestController
@RequestMapping
@Validated
public class EducationController {
    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/users/{id}/educations")
    public List<Education> getUserInfo(@PathVariable("id") long id){
        return educationService.getEducationById(id);
    }

    @PostMapping("/users/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@PathVariable("id") long id, @RequestBody @Valid Education education) {
        educationService.createEducation(id,education);
    }
}
