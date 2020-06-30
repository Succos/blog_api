package com.succos.service.impl;

import com.succos.mapper.BlogTypeMapper;
import com.succos.pojo.BlogType;
import com.succos.service.TypeService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/21 10:28
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Autowired
    private Sid sid;

    /**
     * 添加
     *
     * @param type
     */
    @Override
    public void save(BlogType type) throws Exception {
        // 查询分类是否存在
        String id = sid.nextShort();
        BlogType oldType = blogTypeMapper.getByName(type.getTypeName());
        if(oldType != null) {
            //
            throw new Exception("分类已经存在");
        }
        type.setTypeId(id);
        type.setTypeId(id);
        type.setTypeBlogCount(0);
        type.setEnable(0);
        type.setDeleted(0);
        blogTypeMapper.insert(type);
    }

    public List<BlogType> getAll() {
        List<BlogType> blogTypes = blogTypeMapper.selectAll();
        return blogTypes;
    }

    public BlogType getTypeById(String id) {
        Example typeExample = new Example(BlogType.class);
        Example.Criteria typeCriteria = typeExample.createCriteria();
        typeCriteria.andEqualTo("typeId", id);
        BlogType blogType = blogTypeMapper.selectOneByExample(typeExample);
        return blogType;
    }

    public Boolean update(BlogType type) {
        Example typeExample = new Example(BlogType.class);
        Example.Criteria typeCriteria = typeExample.createCriteria();
        typeCriteria.andEqualTo("typeId", type.getTypeId());
        int i = blogTypeMapper.updateByExampleSelective(type, typeExample);
        return i == 1;
    }
    public Boolean enable(String id){
        BlogType blogType = blogTypeMapper.getTypeById(id);
        blogType.setEnable(1);
        blogTypeMapper.update(blogType);
        return true;
    }
    public Boolean disable(String id){
        BlogType blogType = blogTypeMapper.getTypeById(id);
        blogType.setEnable(0);
        blogTypeMapper.update(blogType);
        return true;
    }
    public Boolean delete(String id){
        BlogType blogType = blogTypeMapper.getTypeById(id);
        blogType.setDeleted(1);
        blogTypeMapper.update(blogType);
        return true;
    }
}
