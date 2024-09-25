package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mapper.CustomerMapper;
import com.example.mapper.PostMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testSelectOneToMany() {
        MPJLambdaWrapper<PostDO> wrapper = new MPJLambdaWrapper<PostDO>()
                .selectAll(PostDO.class)
                .selectCollection(CommentDO.class, PostDTO::getComments)
                .leftJoin(CommentDO.class, CommentDO::getPostId, PostDO::getId)
                .eq(PostDO::getId, 1);

        PostDTO result = postMapper.selectJoinOne(PostDTO.class, wrapper);

        System.out.println(result);
        result.getComments().forEach(System.out::println);
    }

    @Test
    public void testSelectJoinPage() {
        MPJLambdaWrapper<PostDO> wrapper = new MPJLambdaWrapper<PostDO>()
                .selectAll(PostDO.class)
                .selectCollection(CommentDO.class, PostDTO::getComments)
                .leftJoin(CommentDO.class, CommentDO::getPostId, PostDO::getId);
        IPage<PostDTO> entities =
                postMapper.selectJoinPage(Page.of(1, 5, true), PostDTO.class, wrapper);
        assertEquals(5, entities.getRecords().size());
        assertEquals(5, entities.getSize());
        assertEquals(7, entities.getTotal());

        System.out.println(entities);
    }

    @Test
    public void testSelectPage(){
        IPage<PostDO> selectPage = new Page<PostDO>(1, 5, true);
        LambdaQueryWrapper<PostDO> wrapper = new LambdaQueryWrapper<PostDO>();
        IPage<PostDO> entities = postMapper.selectPage(selectPage, wrapper);
        assertEquals(5, entities.getRecords().size());
        assertEquals(5, entities.getSize());
        assertEquals(7, entities.getTotal());

        System.out.println(entities);
    }

}
