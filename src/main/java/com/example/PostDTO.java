package com.example;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class PostDTO {
    private Long id;
    private String title;
    private List<CommentDO> comments;
}
