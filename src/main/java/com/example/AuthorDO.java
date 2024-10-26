package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("book")
public class AuthorDO {
    private Long id;
    private String name;
    private Long age;
}
