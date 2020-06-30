package com.succos.controller;

import com.succos.pojo.bo.BlogArticleBO;
import com.succos.pojo.vo.BlogVo;
import com.succos.service.BlogArticleService;
import com.succos.utils.Page;
import com.succos.utils.SUCCOSJSONResult;
import com.succos.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author succos
 * @version 1.0
 * @date 2020/5/30 12:16
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogArticleService blogService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public SUCCOSJSONResult save(@RequestBody  BlogArticleBO blogArticleBO) {
        blogService.save(blogArticleBO);
        return SUCCOSJSONResult.ok();
    }
    @RequestMapping(value = "/getByPage",method = RequestMethod.POST)
    public SUCCOSJSONResult getByPage(@RequestBody Page<BlogVo> page) {
        String sortColumn = page.getSortColumn();
        if (StringUtils.isNotBlank(sortColumn)) {
            // 排序列不为空
            String[] sortColumns = {"blog_goods", "blog_read", "blog_collection",
                    "type_name", "blog_comment", "created_time", "update_time"};
            List<String> sortList = Arrays.asList(sortColumns);
            if (!sortList.contains(sortColumn.toLowerCase())) {
               return SUCCOSJSONResult.errorMsg("排序参数不合法");
            }
        }
        page = blogService.getByPage(page);
        return new SUCCOSJSONResult(page);
    }


}
