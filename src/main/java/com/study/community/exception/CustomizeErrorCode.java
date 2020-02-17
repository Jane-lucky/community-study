package com.study.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOTFOUND("你找的问题不在了，要不换个试试");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
