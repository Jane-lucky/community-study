package com.study.community.dto;

import com.study.community.Model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreat;
    private  Long gmtModified;
    private Integer creator;
    private String tag;
    private Integer viewCount;
    private  Integer commentCount;
    private Integer likeCount;
    private User user;
}
