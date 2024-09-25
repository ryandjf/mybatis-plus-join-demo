DELETE FROM customer;

INSERT INTO customer (id, name, age, email)
VALUES (1, 'Jone', 18, 'test1@baomidou.com'),
       (2, 'Jack', 20, 'test2@baomidou.com'),
       (3, 'Tom', 28, 'test3@baomidou.com'),
       (4, 'Sandy', 21, 'test4@baomidou.com'),
       (5, 'Billie', 24, 'test5@baomidou.com'),
       (6, 'William', 24, 'test6@baomidou.com'),
       (7, 'Ryan', 24, 'test7@baomidou.com');

DELETE
FROM address;

INSERT INTO address (id, customer_id, city, address)
VALUES (1, 1, '北京', '人民广场'),
       (2, 2, '上海', '人民广场'),
       (3, 3, '广州', '人民广场'),
       (4, 4, '上海', '人民广场'),
       (5, 5, '北京', '人民广场'),
       (6, 1, '成都', '人民广场'),
       (7, 2, '杭州', '人民广场'),
       (8, 1, '成都', '人民广场'),
       (9, 1, '成都', '人民广场');

DELETE FROM post;
INSERT INTO post (id, title)
VALUES (1, '活动'),
       (2, '公告'),
       (3, '新闻'),
       (4, '招聘'),
       (5, '论坛'),
       (6, '产品'),
       (7, '服务');

DELETE FROM comment;
INSERT INTO comment (id, post_id, content)
VALUES (1, 1, '活动内容'),
       (2, 2, '公告内容'),
       (3, 3, '新闻内容'),
       (4, 4, '招聘内容'),
       (5, 5, '论坛内容'),
       (6, 1, '活动内容2'),
       (7, 1, '活动内容3');