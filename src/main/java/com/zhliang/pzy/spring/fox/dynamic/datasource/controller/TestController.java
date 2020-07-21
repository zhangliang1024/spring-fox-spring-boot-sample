package com.zhliang.pzy.spring.fox.dynamic.datasource.controller;

import com.zhliang.pzy.spring.fox.dynamic.datasource.po.Test;
import com.zhliang.pzy.spring.fox.dynamic.datasource.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @创建人：zhiang
 * @创建时间：2020/7/21 17:06
 * @version：V1.0
 */
@Api(tags="Test 测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService tService;

    @ApiOperation("创建")
    @PostMapping("save")
    public int saveT(@RequestBody Test t){
        return tService.save(t);
    }
    @ApiOperation("更新")
    @PostMapping("update")
    public void update(@RequestBody Test t){
        tService.update(t);
    }
    @ApiOperation("查找")
    @PostMapping("{id}")
    public Test findById(@PathVariable("id") int id){
        return tService.findT(id);
    }
    @ApiOperation("查找全部")
    @PostMapping("list")
    public List<Test> list(){
        return tService.selectList();
    }
}
