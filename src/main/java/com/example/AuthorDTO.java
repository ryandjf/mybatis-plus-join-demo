package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("book")
public class AuthorDTO {
    private Long id;
    private String name;
    private Long age;
    private List<BookDO> books;
}
