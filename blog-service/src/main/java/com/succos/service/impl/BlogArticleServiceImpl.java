package com.succos.service.impl;

import com.succos.mapper.BlogArticleMapper;
import com.succos.pojo.bo.BlogArticleBO;
import com.succos.pojo.vo.BlogVo;
import com.succos.service.BlogArticleService;
import com.succos.utils.Page;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/25 12:10
 */
@Service
public class BlogArticleServiceImpl implements BlogArticleService {
    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Autowired
    private Sid sid;
    @Override
    public void save(BlogArticleBO article) {
        String id = sid.nextShort();
        article.setBlogId(id);
        blogArticleMapper.save(article);
    }

    @Override
    public Page<BlogVo> getByPage(Page<BlogVo> page) {
        // 查询数据
        List<BlogVo> blogVoList = blogArticleMapper.getByPage(page);
        page.setList(blogVoList);
        // 查询总数
        int totalCount = blogArticleMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }
}
