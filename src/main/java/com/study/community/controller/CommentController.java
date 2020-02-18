package com.study.community.controller;
import com.study.community.Model.Comment;
import com.study.community.Model.User;
import com.study.community.dto.CommentDTO;
import com.study.community.dto.ResultDTO;
import com.study.community.exception.CustomizeErrorCode;
import com.study.community.service.CommnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CommentController {
    @Autowired
    private CommnetService commnetService;
    @ResponseBody
    @RequestMapping(value = "/commnet",method = RequestMethod.POST)//采用JSON的方式：网络传输的一种对象
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){
        User user=(User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentaor(user.getId());
        comment.setLikeCount(0L);
        commnetService.insert(comment);
        return ResultDTO.okOf();
    }
}
