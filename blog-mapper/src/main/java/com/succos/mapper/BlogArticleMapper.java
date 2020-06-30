package com.succos.mapper;

import com.succos.my.mapper.MyMapper;
import com.succos.pojo.BlogArticle;
import com.succos.pojo.bo.BlogArticleBO;
import com.succos.pojo.vo.BlogVo;
import com.succos.utils.Page;

import java.util.List;

public interface BlogArticleMapper extends MyMapper<BlogArticle> {
    void save(BlogArticleBO blogArticleBO);
    List<BlogVo> getByPage(Page<BlogVo> page);
    /**
     * 查询总数
     * @param page
     * @return
     */
    int getCountByPage(Page<BlogVo> page);
}