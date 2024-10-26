package com.example.mapper;

import com.example.BookDO;
import com.example.AuthorDO;
import com.example.AuthorDTO;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper extends MPJBaseMapper<AuthorDO> {
    List<AuthorDTO> findAuthorsWithBooks(String publisher);

    List<BookDO> findBooksByAuthor(Long authorId);
}
