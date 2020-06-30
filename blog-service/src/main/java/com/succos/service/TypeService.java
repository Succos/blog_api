package com.succos.service;

import com.succos.pojo.BlogType;

import java.util.List;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/21 10:30
 */
public interface TypeService {
    void save(BlogType type) throws Exception;
     List<BlogType> getAll();
     BlogType getTypeById(String id);
     Boolean update(BlogType type);
     Boolean enable(String id);
     Boolean disable(String id);
     Boolean delete(String id);
}
