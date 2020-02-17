package com.study.community.controller;

import com.study.community.Mapper.CommentMapper;
import com.study.community.Model.Comment;
import com.study.community.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @RequestMapping(value = "/commnet",method = RequestMethod.POST)//采用JSON的方式：网络传输的一种对象
    public Object post(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentaor(1);
        commentMapper.insert(comment);
        return null;
    }
}
