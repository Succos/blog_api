package com.succos.service;

import com.succos.pojo.bo.BlogArticleBO;
import com.succos.pojo.vo.BlogVo;
import com.succos.utils.Page;

/**
 * @author succos
 * @version 1.0
 * @date 2020/6/25 12:09
 */
public interface BlogArticleService {
    void save(BlogArticleBO article);
    Page<BlogVo> getByPage(Page<BlogVo> page);
}
