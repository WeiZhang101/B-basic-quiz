package com.example.quiz1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private long id;

    @Size(min = 1, max = 128, message = "用户名长度不合法")
    private String name;

    @Min(value = 17, message = "年龄必须大于16")
    private long age;

    @Size(min = 8, max = 512, message = "地址长度不合法")
    private String avatar;

    @Size(min = 0, max = 1024, message = "个人介绍长度不合法")
    private String description;

//    @JsonIgnore
//    private List<Education> educations = new ArrayList<>();

    public User(long id, String name, long age, String avatar, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avatar = avatar;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
