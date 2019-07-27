package com.cskaoyan.wdjava.service.impl;

import com.cskaoyan.wdjava.bean.WdStudentInsert;
import com.cskaoyan.wdjava.mapper.WdInsertMapper;
import com.cskaoyan.wdjava.service.WdInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WdInsertServiceImpl implements WdInsertService {

    @Autowired
    WdInsertMapper wdStudentInfoMapper;

    @Override
    public boolean insertStudentMessage(WdStudentInsert studentInsert) {

        // 判空
        // 插入学生信息表
        // 插入座位信息表

        wdStudentInfoMapper.insertStudentInfo(studentInsert);
        wdStudentInfoMapper.insertSeatArrange(studentInsert);

        System.out.println(studentInsert);

        return false;
    }
}
