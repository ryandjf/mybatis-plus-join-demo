package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("post")
public class PostDO {
    private Long id;
    private String title;
}
