package com.example.quiz1;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private long userId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    @Max(value = 2020, message = "时间必须是历年")
    private long year;

    @Size(min = 1, max = 256, message = "教育标题不合法")
    private String title;

    @Size(min = 1, max = 4096, message = "教育经历长度不合法")
    private String description;

    public void setUser(User user) {
        this.user = user;
    }

//    public void setUserId(long userId) {
//        this.userId = userId;
//    }
}
