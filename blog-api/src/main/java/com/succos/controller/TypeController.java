package com.succos.controller;

import com.succos.pojo.BlogType;
import com.succos.service.TypeService;
import com.succos.utils.SUCCOSJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author succos
 * @version 1.0
 * @date 2020/5/30 12:16
 */
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public SUCCOSJSONResult save(@RequestBody BlogType type) throws Exception {
        typeService.save(type);
        return SUCCOSJSONResult.ok();
    }

    @RequestMapping(value = "/listBack",method = RequestMethod.GET)
    public SUCCOSJSONResult list() {
        List<BlogType> list =  typeService.getAll();
        return new SUCCOSJSONResult(list);
    }
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public SUCCOSJSONResult getList() {
        List<BlogType> list =  typeService.getAll();
        return new SUCCOSJSONResult(list);
    }
    /**
     * 根据id查询分类
     * @return
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public SUCCOSJSONResult get(@PathVariable String id) {
        BlogType typeById = typeService.getTypeById(id);
        return new SUCCOSJSONResult(typeById);
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public SUCCOSJSONResult update(@PathVariable String id) {
        Boolean update = typeService.enable(id);
        if (update){
            return SUCCOSJSONResult.ok();
        }
        return SUCCOSJSONResult.errorMsg("更新失败");

    }
    /**
     * 取用enable
     */

    @RequestMapping(value = "/enable/{id}",method = RequestMethod.PUT)
    public SUCCOSJSONResult enable(@PathVariable String id) {
        Boolean update = typeService.enable(id);
        if (update){
            return SUCCOSJSONResult.ok();
        }
        return SUCCOSJSONResult.errorMsg("更新失败");

    }
    @RequestMapping(value = "/disable/{id}",method = RequestMethod.PUT)
    public SUCCOSJSONResult disable(@PathVariable String id) {
        Boolean update = typeService.disable(id);
        if (update){
            return SUCCOSJSONResult.ok();
        }
        return SUCCOSJSONResult.errorMsg("更新失败");

    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public SUCCOSJSONResult delete(@PathVariable String id) {
        Boolean update = typeService.delete(id);
        if (update){
            return SUCCOSJSONResult.ok();
        }
        return SUCCOSJSONResult.errorMsg("更新失败");

    }



}
