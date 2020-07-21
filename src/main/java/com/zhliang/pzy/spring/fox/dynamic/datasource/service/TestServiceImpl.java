package com.zhliang.pzy.spring.fox.dynamic.datasource.service;

import com.zhliang.pzy.dynamic.datasource.annotation.Master;
import com.zhliang.pzy.spring.fox.dynamic.datasource.po.Test;
import com.zhliang.pzy.spring.fox.dynamic.datasource.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建时间：2020/7/21 17:03
 * @version：V1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper tMapper;

    @Override
    public int save(Test t) {
        return tMapper.insert(t);
    }

    @Master
    @Override
    public Test findT(int id) {
        return tMapper.selectById(id);
    }

    @Override
    public void update(Test t) {
        tMapper.updateByPrimarkey(t);
    }

    @Override
    public List<Test> selectList() {
        return tMapper.selectAll();
    }
}
