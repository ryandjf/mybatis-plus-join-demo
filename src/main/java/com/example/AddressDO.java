package com.example;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("address")
public class AddressDO {
    private Long id;
    private Long customerId;
    private String city;
    private String address;
}
