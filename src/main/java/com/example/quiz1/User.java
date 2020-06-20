package com.example.quiz1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private long id;

    @Size(min = 1, max = 128, message = "用户名长度不合法")
    private String name;

//    @Pattern(regexp = "/＾1［7－9］＄｜＾［2－9］＼d＄｜＾1＼d｛2｝＄／")
    private long age;

    @Size(min = 8, max = 512, message = "地址长度不合法")
    private String avatar;

    @Size(min = 0, max = 1024, message = "个人介绍长度不合法")
    private String description;

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
}
