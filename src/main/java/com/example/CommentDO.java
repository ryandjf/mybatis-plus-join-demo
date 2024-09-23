package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("comment")
public class CommentDO {
    private Long id;
    private Long postId;
    private String content;
}
