package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("customer")
public class CustomerDO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
