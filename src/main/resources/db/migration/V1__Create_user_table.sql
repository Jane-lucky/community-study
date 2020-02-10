create table USER
(
    ID INT auto_increment primary key,
    ACCOUNT VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN CHAR(36),
    GMT_CREAT BIGINT,
    GMT_MODIFIED BIGINT,
    BIO VARCHAR(256),
    AVATAR_URL VARCHAR(100)
);