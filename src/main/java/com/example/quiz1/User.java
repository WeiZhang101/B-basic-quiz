package com.example.quiz1;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(min = 1, max = 128, message = "用户名长度不合法")
    private String name;

    @Min(value = 17, message = "年龄必须大于16")
    private long age;

    @Size(min = 8, max = 512, message = "地址长度不合法")
    private String avatar;

    @Size(min = 0, max = 1024, message = "个人介绍长度不合法")
    private String description;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "user")
//    private List<Education> educations;
//
//    public void addEducation(Education education) {
//        educations.add(education);
//    }
}
