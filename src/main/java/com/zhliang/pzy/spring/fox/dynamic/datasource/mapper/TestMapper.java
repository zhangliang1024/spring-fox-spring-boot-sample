package com.zhliang.pzy.spring.fox.dynamic.datasource.mapper;

import com.zhliang.pzy.spring.fox.dynamic.datasource.po.Test;

import java.util.List;

/**
 * @Author: zhliang
 * @Date: 2020/7/21 17:01
 * @Description:
 * @Version: V1.0
 */
public interface TestMapper {

    int insert(Test t);

    Test selectById(int id);

    void updateByPrimarkey(Test t);

    List<Test> selectAll();
}
