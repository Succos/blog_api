package com.succos.mapper;

import com.succos.my.mapper.MyMapper;
import com.succos.pojo.BlogType;


public interface BlogTypeMapper extends MyMapper<BlogType> {
    /**
     * 根据名称查询分类是否存在
     * @param typeName
     * @return
     */
    BlogType getByName(String typeName);
    BlogType enableById(String id);
    BlogType getTypeById(String id);
    void update(BlogType type);

    /**
     * 插入
     * @param type
     * @return
     */
}