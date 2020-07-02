package com.example.quiz1;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Setter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long userId;


//    @JoinColumn(name = "post_id")
    @ManyToOne(cascade = CascadeType.ALL)
//    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

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
