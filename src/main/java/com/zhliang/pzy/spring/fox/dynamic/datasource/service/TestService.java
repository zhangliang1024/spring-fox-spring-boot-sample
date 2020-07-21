package com.zhliang.pzy.spring.fox.dynamic.datasource.service;

import com.zhliang.pzy.spring.fox.dynamic.datasource.po.Test;

import java.util.List;

/**
 * @Author: zhliang
 * @Date: 2020/7/21 17:01
 * @Description:
 * @Version: V1.0
 */
public interface TestService {

    int save(Test t);

    Test findT(int id);

    void update(Test t);

    List<Test> selectList();
}
