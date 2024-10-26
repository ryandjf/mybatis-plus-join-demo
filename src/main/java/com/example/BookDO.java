package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("author")
public class BookDO {
    private Long id;
    private Long authorId;
    private String title;
    private String publisher;
}
