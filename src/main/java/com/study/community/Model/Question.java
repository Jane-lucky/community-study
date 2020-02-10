package com.study.community.Model;

import lombok.Data;

@Data
public class Question {
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
}
