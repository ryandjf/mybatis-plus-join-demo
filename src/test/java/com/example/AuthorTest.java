package com.example;

import com.example.mapper.AuthorMapper;
import com.example.mapper.CustomerMapper;
import com.example.mapper.PostMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthorTest {

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void testSelect() {

        List<AuthorDTO> authors = authorMapper.findAuthorsWithBooks("Pub A");

        authors.forEach(System.out::println);
    }

}
