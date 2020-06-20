package com.example.quiz1;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Education {
    private long userId;

//    @Past(message = "时间必须是历年")
    @Max(value = 2020, message = "时间必须是历年")
    private long year;

    @Size(min = 1, max = 256, message = "教育标题不合法")
    private String title;

    @Size(min = 1, max = 4096, message = "教育经历长度不合法")
    private String description;

    public long getUserId() {
        return userId;
    }

    public Education(long userId, long year, String title, String description) {
        this.userId = userId;
        this.year = year;
        this.title = title;
        this.description = description;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
