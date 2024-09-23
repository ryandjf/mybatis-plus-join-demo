package com.example;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerDTO {
    private Long id;
    private String name;
    private Integer age;
    private String email;

    private String city;
    private String address;
}
