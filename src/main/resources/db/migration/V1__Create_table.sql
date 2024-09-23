DROP TABLE IF EXISTS customer;

CREATE TABLE customer
(
    id    BIGINT(20) NOT NULL COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS address;

CREATE TABLE address
(
    id      BIGINT(20) NOT NULL COMMENT '主键ID',
    customer_id BIGINT(20) NULL DEFAULT NULL COMMENT '用户id',
    city    VARCHAR(50) NULL DEFAULT NULL COMMENT '城市',
    address VARCHAR(50) NULL DEFAULT NULL COMMENT '地址',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS post;

CREATE TABLE post
(
    id    BIGINT(20) NOT NULL COMMENT '主键ID',
    title  VARCHAR(30) NULL DEFAULT NULL COMMENT '标题',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS comment;

CREATE TABLE comment
(
    id    BIGINT(20) NOT NULL COMMENT '主键ID',
    post_id BIGINT(20) NULL DEFAULT NULL COMMENT '帖子id',
    content VARCHAR(50) NULL DEFAULT NULL COMMENT '内容',
    PRIMARY KEY (id)
);
