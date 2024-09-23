package com.example;

import com.example.mapper.CustomerMapper;
import com.example.mapper.PostMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void testSelect() {
        MPJLambdaWrapper<CustomerDO> wrapper = new MPJLambdaWrapper<CustomerDO>()
                .selectAll(CustomerDO.class)//查询Customer表全部字段
                .select(AddressDO::getCity, AddressDO::getAddress)
                .leftJoin(AddressDO.class, AddressDO::getCustomerId, CustomerDO::getId);

        List<CustomerDTO> userList = customerMapper.selectJoinList(CustomerDTO.class, wrapper);

        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectOneToMany(){
        MPJLambdaWrapper<PostDO> wrapper = new MPJLambdaWrapper<PostDO>()
                .selectAll(PostDO.class)
                .selectCollection(CommentDO.class, PostDTO::getComments)
                .leftJoin(CommentDO.class, CommentDO::getPostId, PostDO::getId)
                .eq(PostDO::getId, 1);

        PostDTO result = postMapper.selectJoinOne(PostDTO.class, wrapper);

        System.out.println(result);
        result.getComments().forEach(System.out::println);
    }

}
