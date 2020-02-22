package com.study.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不换个试试"),
    TAGGET_NOT_FOUND(2002,"未选中任何问题进行回复"),
    NOT_LOGIN(2003,"未登录不能进行评论，请先登录"),
    SYS_ERROR(2004,"服务出错啦,稍后再试试"),
    TYPE_PARAM_WRONG(2005,"评论类型不存在"),
    COMMRNT_NOT_FOUND(2006,"回复评论不存在，换一个试试"),
    CONTENT_IS_EMPTY(2007,"回复内容不能为空");
    private String message;
    private Integer code;

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code=code;
    }

    public String getMessage() {
        return message;
    }
}
